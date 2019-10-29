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
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCompositeCount extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new SimpleCompositeCount(), args);
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

        final String HDFS = "hdfs://localhost:9000";
        Path inputFile = new Path(new URI(HDFS + args[0]));
        Path outputPath = new Path(new URI(HDFS + args[1]));
        DblpMapper.setRequiredFields(args[2].toLowerCase());

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Simple Count");
        job.setJarByClass(SimpleCompositeCount.class);
        job.setMapperClass(DblpMapper.class);
        job.setReducerClass(IntSumReducer.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpMapper extends Mapper<Text, PublicationWritable, Text, IntWritable> {

        private static final IntWritable ONE = new IntWritable(1);
        private static String[] requiredFields;
        private Text tag = new Text();

        static void setRequiredFields(String fieldKeys) {
            requiredFields = fieldKeys.split(",");
        }

        static boolean getRequiredFieldType(String fieldKey) {
            return !fieldKey.matches("authors|editors|urls|ees|cites|schools");
        }

        static List<String> getCompositeField(List<List<String>> fields) {
            if (requiredFields.length == 2) {
                return getFieldPair(fields);
            }
            if (requiredFields.length == 3) {
                return getFieldTriplet(fields);
            }
            return fields.get(0);
        }

        // TODO: Sort this madness, combine getFieldPair and getFieldTriplet functions
        static List<String> getFieldPair(List<List<String>> fields) {
            return Arrays.stream(fields.get(0).toArray())
                    .flatMap(s1 -> Arrays.stream(fields.get(1).toArray())
                            .map(s2 -> s1.toString() + "\t" + s2.toString()))
                    .collect(Collectors.toList());
        }

        static List<String> getFieldTriplet(List<List<String>> fields) {
            return Arrays.stream(fields.get(0).toArray())
                    .flatMap(s1 -> Arrays.stream(fields.get(1).toArray())
                            .flatMap(s2 -> Arrays.stream(fields.get(2).toArray())
                                    .map(s3 -> s1.toString() + s2.toString() + s3.toString())))
                    .collect(Collectors.toList());
        }

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param key
         * @param publication
         * @param context
         */
        @Override
        protected void map(Text key, PublicationWritable publication, Context context) throws IOException, InterruptedException {
            List<List<String>> fields = new ArrayList<>(3);

            // Do not allow combining more than 3 fields
            for (int i = 0; i < requiredFields.length && i < 3; i++) {
                String requiredField = requiredFields[i];
                String methodName = "get" + requiredField.substring(0, 1).toUpperCase() + requiredField.substring(1);
                if (getRequiredFieldType(requiredField)) {
                    try {
                        String keyString = String.valueOf(getMethod(publication, methodName).invoke(publication));
                        keyString = keyString.isEmpty() ? "" : keyString;
                        fields.add(i, Collections.singletonList(keyString));
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        List<String> keyStrings = (List<String>) getMethod(publication, methodName).invoke(publication);
                        keyStrings = keyStrings.isEmpty() ? Collections.singletonList("") : keyStrings;
                        fields.add(i, keyStrings);
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            // System.out.println("FIELDS: " + fields);

            List<String> compositeFields = getCompositeField(fields);
            // System.out.println("COMPOSITEFIELDS: " + compositeFields);

            for (String compositeField : compositeFields) {
                tag.set(new Text(compositeField));
                context.write(tag, ONE);
            }
            // TODO: Filter by fields
            // TODO: Discard duplicate composite keys
        }

        Method getMethod(PublicationWritable pw, String methodName) throws NoSuchMethodException {
            return pw.getClass().getMethod(methodName);
        }
    }
}
