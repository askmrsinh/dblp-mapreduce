package com.ashessin.cs441.hw2.dblp.mr;

import com.ashessin.cs441.hw2.dblp.utils.PublicationWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setOutputCompressorClass;
import static org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat.*;

public class CompositeCount extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new CompositeCount(), args);
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
        conf.set("mapred.compress.map.output", "true");
        conf.set("mapred.output.compression.type", "BLOCK");
        conf.set("mapred.map.output.compression.codec", "org.apache.hadoop.io.compress.DefaultCodec");

        final String HDFS = "hdfs://localhost:9000";
        Path inputFile = new Path(new URI(HDFS + args[0]));
        Path outputPath = new Path(new URI(HDFS + args[1]));
        DblpCompositeCountMapper.setRequiredFields(args[2]);

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Composite Count");
        job.setJarByClass(CompositeCount.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpCompositeCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        setOutputCompressionType(job, SequenceFile.CompressionType.BLOCK);
        setOutputCompressorClass(job, DefaultCodec.class);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpCompositeCountMapper extends Mapper<Text, PublicationWritable, Text, IntWritable> {

        private static final IntWritable ONE = new IntWritable(1);
        private static String[] requiredFields;
        private Text tag = new Text();

        static String[] getRequiredFields() {
            return requiredFields;
        }

        static void setRequiredFields(String fieldKeys) {
            requiredFields = fieldKeys.toLowerCase().split(",");
        }

        static boolean getRequiredFieldType(String fieldKey) {
            return !fieldKey.matches("authors|editors|urls|ees|cites|schools");
        }

        static LinkedHashSet<String> getCompositeField(List<List<String>> fields) {
            if (requiredFields.length == 2) {
                return getFieldPair(fields);
            }
            if (requiredFields.length == 3) {
                return getFieldTriplet(fields);
            }
            return (LinkedHashSet<String>) fields.get(0);
        }

        static LinkedHashSet<String> getFieldPair(List<List<String>> fields) {
            return Arrays.stream(fields.get(0).toArray())
                    .flatMap(s1 -> Arrays.stream(fields.get(1).toArray())
                            .map(s2 -> {
                                List<String> f = Arrays.asList(s1.toString(), s2.toString());
                                return new HashSet<>(f).size() == 2 ? s1.toString() +
                                        "\t" + s2.toString() : "";
                            })).filter(s -> s.length() > 0)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        static LinkedHashSet<String> getFieldTriplet(List<List<String>> fields) {
            return Arrays.stream(fields.get(0).toArray())
                    .flatMap(s1 -> Arrays.stream(fields.get(1).toArray())
                            .flatMap(s2 -> Arrays.stream(fields.get(2).toArray())
                                    .map(s3 -> {
                                        List<String> f = Arrays.asList(s1.toString(), s2.toString(), s3.toString());
                                        return new HashSet<>(f).size() == 3 ? s1.toString() +
                                                "\t" + s2.toString() +
                                                "\t" + s3.toString() : "";
                                    }))).filter(s -> s.length() > 0)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
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

            LinkedHashSet<String> compositeFields = getCompositeField(fields);
            // System.out.println("FIELDS: " + fields);
            // System.out.println("COMPOSITEFIELDS: " + compositeFields);

            for (String compositeField : compositeFields) {
                tag.set(new Text(compositeField));
                context.write(tag, ONE);
            }
            // TODO: Filter by fields
        }

        Method getMethod(PublicationWritable pw, String methodName) throws NoSuchMethodException {
            return pw.getClass().getMethod(methodName);
        }
    }
}
