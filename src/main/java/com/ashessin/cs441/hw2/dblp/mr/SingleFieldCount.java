package com.ashessin.cs441.hw2.dblp.mr;

import com.ashessin.cs441.hw2.dblp.utils.PublicationWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

/**
 * Counts all values of a single field in DBLP records.
 */
public class SingleFieldCount extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new SingleFieldCount(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("Simple Count MR, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("Simple Count MR, Time taken (ms): "
                + (end - start));

        System.exit(res);
    }

    /**
     * Execute the command with the given arguments.
     *
     * @param args command specific arguments.
     * @return exit code.
     * @throws Exception if something goes wrong
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = super.getConf();
        conf.set("mapred.compress.map.output", "true");
        conf.set("mapred.output.compression.type", "BLOCK");
        conf.set("mapred.map.output.compression.codec", "org.apache.hadoop.io.compress.DefaultCodec");

        final String HDFS = "hdfs://localhost:9000";
        Path inputFile = new Path(new URI(HDFS + args[0]));
        Path outputPath = new Path(new URI(HDFS + args[1]));
        DblpSingleFieldCountMapper.setRequiredField(args[2].toLowerCase());

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing hdfs target directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Simple Count");
        job.setJarByClass(SingleFieldCount.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpSingleFieldCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    /**
     * Mapper class to generate unit count against each value for a given field of a DBLP record.
     */
    public static class DblpSingleFieldCountMapper extends Mapper<Text, PublicationWritable, Text, IntWritable> {

        private static final IntWritable ONE = new IntWritable(1);
        private static String requiredField;
        private Text result = new Text();

        static void setRequiredField(String fieldKey) {
            requiredField = fieldKey;
        }

        static boolean getRequiredFieldType(String fieldKey) {
            return !fieldKey.matches("authors|editors|urls|ees|cites|schools");
        }

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param key         the unique key field for a given DBLP publication record
         * @param publication a single DBLP publication record object {@link PublicationWritable}
         * @param context     generate an output result/1 pair
         */
        @Override
        protected void map(Text key, PublicationWritable publication, Context context)
                throws IOException, InterruptedException {
            String methodName = "get" + requiredField.substring(0, 1).toUpperCase() + requiredField.substring(1);
            if (getRequiredFieldType(requiredField)) {
                try {
                    String keyString = String.valueOf(getMethod(methodName).invoke(publication));
                    result.set(new Text(keyString));
                    context.write(result, ONE);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    List<String> keyStrings = (List<String>) getMethod(methodName).invoke(publication);
                    for (String keyString : keyStrings) {
                        result.set(new Text(keyString));
                        context.write(result, ONE);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        /**
         * Uses Java Reflection to gain access to a method in {@link PublicationWritable} class.
         *
         * @param methodName the suffix in a getter method name
         * @return provides access to a getter method from {@link PublicationWritable}
         * @throws NoSuchMethodException if the getter method does not exists
         */
        Method getMethod(String methodName) throws NoSuchMethodException {
            return PublicationWritable.class.getMethod(methodName);
        }
    }
}
