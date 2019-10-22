package com.ashessin.cs441.hw2.dblp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;

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
     * @throws Exception
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = super.getConf();

        Path inputFile = new Path(new URI("hdfs://localhost:9000" + args[0]));

        SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                SequenceFile.Reader.file(inputFile));

        try {
            System.out.println("Is block compressed = " + reader.isBlockCompressed());

            Text k = new Text();
            PublicationsWritable value = new PublicationsWritable();

            while (reader.next(k, value)) {
                System.out.println(k + "\t" + value);
            }
        } finally {
            reader.close();
        }

        return 0;
    }
}
