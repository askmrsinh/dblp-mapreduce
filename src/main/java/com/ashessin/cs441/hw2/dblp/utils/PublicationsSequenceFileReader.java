package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * DBLP Publications sequence file reader.
 */
public final class PublicationsSequenceFileReader extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(PublicationsSequenceFileReader.class);

    public static void main(String[] args) throws Exception {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new PublicationsSequenceFileReader(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        logger.info("PublicationsSequenceFileReader, Memory used (bytes): {}", memend - memstart);
        logger.info("PublicationsSequenceFileReader, Time taken (ms): {}", end - start);

        // System.exit(res);
    }

    /**
     * Execute the command with the given arguments.
     *
     * @param args command specific arguments.
     * @return exit code.
     * @throws Exception in case of errors
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = super.getConf();

        Path dblpSequnceFilePath = new Path(args[0]);

        final FileSystem SOURCE_FS = dblpSequnceFilePath.getFileSystem(conf);

        logger.info("Source Filesystem is: {}", SOURCE_FS);

        if(!SOURCE_FS.exists(dblpSequnceFilePath)) throw new FileNotFoundException();

        if (SOURCE_FS.getUri() != new Path(conf.get("fs.defaultFS")).getFileSystem(conf).getUri()) {
            logger.warn("The default filesystem is: {}", conf.get("fs.defaultFS"));
        }

        try (SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                SequenceFile.Reader.file(dblpSequnceFilePath))) {
            logger.debug("Is block compressed = " + reader.isBlockCompressed());

            Text k = new Text();
            PublicationWritable value = new PublicationWritable();

            while (reader.next(k, value)) {
                logger.info("{}\t{}", k, value);
            }
        }

        return 0;
    }
}
