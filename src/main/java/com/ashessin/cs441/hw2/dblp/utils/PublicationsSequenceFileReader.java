package com.ashessin.cs441.hw2.dblp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

/**
 * DBLP Publications sequence file reader.
 */
public class PublicationsSequenceFileReader extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new PublicationsSequenceFileReader(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("Sequence File Writer, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("Sequence File Writer, Time taken (ms): "
                + (end - start));

        System.exit(res);
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

        final String HDFS = "hdfs://localhost:9000";
        Path inputFilePath = new Path(new URI(HDFS + args[0]));

        try (SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                SequenceFile.Reader.file(inputFilePath))) {
            System.out.println("Is block compressed = " + reader.isBlockCompressed());

            Text k = new Text();
            PublicationWritable value = new PublicationWritable();

            while (reader.next(k, value)) {
                System.out.println(k + "\t" + value);
            }
        }

        return 0;
    }
}
