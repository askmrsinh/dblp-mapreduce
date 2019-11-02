package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Copies a file from HDFS to local filesystem.
 */
public final class CopyHdfsFileToLocal extends Configured implements Tool {

    public static void main(final String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new CopyHdfsFileToLocal(), args);
        // System.exit(res);
    }

    public int run(final String[] args) throws Exception {
        Configuration conf = super.getConf();

        final String CWD = System.getProperty("user.dir") + File.separator;
        final String HDFS = "hdfs://localhost:9000";
        String hdfsFilePath = HDFS + args[0];

        Path hdfsFile = new Path(new URI(hdfsFilePath));
        String outputFilePath;
        if (args.length < 2) {
            outputFilePath = CWD + hdfsFile.getName();
        } else {
            outputFilePath = args[1];
        }
        File outputFile = new File(outputFilePath);

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        try (InputStream is = hdfs.open(hdfsFile)) {
            System.out.println("Copying to " + outputFilePath);
            OutputStream os = FileUtils.openOutputStream(outputFile);
            IOUtils.copyBytes(is, os, getConf(), true);
            Thread.sleep(5);
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
