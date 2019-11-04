package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.apache.hadoop.fs.CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY;
import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * Copies a file from HDFS to local filesystem.
 */
public final class CopyHdfsFileToLocal extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(CopyHdfsFileToLocal.class);

    public static void main(final String[] args) throws Exception {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        // org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
        int res = ToolRunner.run(new Configuration(), new CopyHdfsFileToLocal(), args);
        // System.exit(res);
    }

    public int run(final String[] args) throws Exception {
        Configuration conf = super.getConf();

        Path sourceFilePath = new Path(args[0]);
        Path targetFilePath = new Path(args[1]);

        final FileSystem SOURCE_FS = sourceFilePath.getFileSystem(conf);
        final FileSystem TARGET_FS = targetFilePath.getFileSystem(conf);

        logger.info("Source Filesystem is: {}", SOURCE_FS);
        logger.info("Target Filesystem is: {}", TARGET_FS);

        if (SOURCE_FS.getUri() == TARGET_FS.getUri()) {
            conf.set(FS_DEFAULT_NAME_KEY, String.valueOf(TARGET_FS.getUri()));
            logger.info("Setting default filesystem as: {}", conf.get(FS_DEFAULT_NAME_KEY));
        } else {
            logger.warn("The default filesystem is: {}", conf.get(FS_DEFAULT_NAME_KEY));
        }

        try (InputStream is = SOURCE_FS.open(sourceFilePath).getWrappedStream()) {
            logger.info("Copying {} to {}", sourceFilePath, targetFilePath);
            try (OutputStream os = TARGET_FS.create(targetFilePath, true).getWrappedStream()) {
                IOUtils.copyBytes(is, os, getConf(), true);
            }
            Thread.sleep(5);
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
}
