package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * DBLP Publications sequence file reader.
 */
public final class PublicationsSequenceFileReader extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(PublicationsSequenceFileReader.class);

    public static void main(String[] args) throws Exception {
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

        final String HDFS = conf.get("fs.defaultFS");
        Path inputFilePath = new Path(new URI(HDFS + args[0]));

        try (SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                SequenceFile.Reader.file(inputFilePath))) {
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
