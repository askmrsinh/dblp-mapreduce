package com.ashessin.cs441.hw2.dblp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.net.URI;
import java.util.ArrayList;

public class PublicationsSequenceFileWriter extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new PublicationsSequenceFileWriter(), args);

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

        String inputFile = args[0];

        Path outputPath = new Path(new URI("hdfs://localhost:9000" + args[1]));

        SequenceFile.Writer writer = SequenceFile.createWriter(conf,
                SequenceFile.Writer.file(outputPath),
                SequenceFile.Writer.keyClass(Text.class),
                SequenceFile.Writer.valueClass(PublicationsWritable.class),
                SequenceFile.Writer.compression(
                        SequenceFile.CompressionType.BLOCK,
                        new DefaultCodec())
        );

        try {
            Text k = new Text();

            for (Publication pub : StaxXMLReader.parseXML(inputFile)) {
                PublicationsWritable publication = new PublicationsWritable(pub.getKey(), pub.getMdate(), pub.getPubltype(),
                        pub.getPublrecord(), (ArrayList<String>) pub.getAuthors());

                System.out.println("Publication :: " + publication);

                k.set(publication.getKey());

                writer.append(k, publication);
            }
        } finally {
            writer.close();
        }

        return 0;
    }
}
