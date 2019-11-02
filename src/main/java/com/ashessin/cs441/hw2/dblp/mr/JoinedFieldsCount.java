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
import static org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat.setOutputCompressionType;

/**
 * Counts all values across multiple fields in DBLP records.
 */
public final class JoinedFieldsCount extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new JoinedFieldsCount(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        System.out.println("Composite Count MR, Memory used (bytes): "
                + (memend - memstart));
        System.out.println("Composite Count MR, Time taken (ms): "
                + (end - start));

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
        conf.set("mapreduce.map.output.compress", "true");
        conf.set("mapreduce.output.fileoutputformat.compress.type", "BLOCK");
        conf.set("mapreduce.map.output.compress.codec", "org.apache.hadoop.io.compress.DefaultCodec");

        final String HDFS = conf.get("fs.defaultFS");
        Path inputFile = new Path(new URI(HDFS + args[0]));
        Path outputPath = new Path(new URI(HDFS + args[1]));
        conf.set("requiredFields", args[2].toLowerCase());

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing hdfs target directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Joined Fields Count");
        job.setJarByClass(JoinedFieldsCount.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpJoinedFieldsCountMapper.class);
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

    public static class DblpJoinedFieldsCountMapper extends Mapper<Text, PublicationWritable, Text, IntWritable> {

        private static final IntWritable ONE = new IntWritable(1);
        private static String[] requiredFields;
        private Text tag = new Text();

        static void setRequiredFields(Mapper.Context context) {
            requiredFields = context.getConfiguration().get("requiredFields").toLowerCase().trim().split(",");
        }

        /**
         * Uses Java Reflection to return class of method return type in {@link PublicationWritable} class.
         *
         * @param methodName the suffix in a getter method name
         * @return provides class for getter method return type from {@link PublicationWritable}
         * @throws NoSuchMethodException if the getter method does not exists
         */
        Class<?> getMethodType(String methodName) throws NoSuchMethodException {
            return PublicationWritable.class.getMethod(methodName).getReturnType();
        }

        static LinkedHashSet<String> retriveCompositeField(ArrayList<ArrayList<String>> fields) {
            if (requiredFields.length == 2) {
                return getFieldPair(fields);
            }
            if (requiredFields.length == 3) {
                return getFieldTriplet(fields);
            }
            return new LinkedHashSet<>(fields.get(0));
        }

        /**
         * Computes the Cartesian product of lists pairs of values.
         *
         * @param fields List of maximum two Lists, each containing values for a given field of a DBLP record
         * @return cartesian product of values across the two nested lists
         */
        static LinkedHashSet<String> getFieldPair(ArrayList<ArrayList<String>> fields) {
            return Arrays.stream(fields.get(0).toArray())
                    .flatMap(s1 -> Arrays.stream(fields.get(1).toArray())
                            .map(s2 -> {
                                List<String> f = Arrays.asList(s1.toString(), s2.toString());
                                return new HashSet<>(f).size() == 2 ? s1.toString() +
                                        "\t" + s2.toString() : "";
                            })).filter(s -> s.length() > 0)
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }

        /**
         * Computes the Cartesian product of lists triplets of values.
         *
         * @param fields List of maximum three Lists, each containing values for a given field of a DBLP record
         * @return cartesian product of values across the three nested lists
         */
        static LinkedHashSet<String> getFieldTriplet(ArrayList<ArrayList<String>> fields) {
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
         * Called once at the beginning of the task.
         *
         * @param context
         */
        @Override
        protected void setup(Context context) throws IOException, InterruptedException {
            super.setup(context);
            setRequiredFields(context);
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
            ArrayList<ArrayList<String>> listOLists = new ArrayList<>(3);

            // Do not allow combining more than 3 fields
            for (int i = 0; i < requiredFields.length && i < 3; i++) {
                String requiredField = requiredFields[i];
                String methodName = "get" + requiredField.substring(0, 1).toUpperCase() + requiredField.substring(1);
                try {
                    ArrayList<String> singleList = new ArrayList<>(1);
                    Object obj = getMethod(methodName).invoke(publication);
                    if (getMethodType(methodName) == List.class) {
                        singleList.addAll((List) obj);
                    } else {
                        singleList.add(getMethod(methodName).invoke(publication).toString());
                    }
                    listOLists.add(i, singleList);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            LinkedHashSet<String> compositeFields = retriveCompositeField(listOLists);
            // System.out.println("FIELDS: " + listOLists);
            // System.out.println("COMPOSITEFIELDS: " + compositeFields);

            for (String compositeField : compositeFields) {
                tag.set(new Text(compositeField));
                context.write(tag, ONE);
            }
            // TODO: Filter by fields
        }

        /**
         * Uses Java Reflection to gain method access in {@link PublicationWritable} class.
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
