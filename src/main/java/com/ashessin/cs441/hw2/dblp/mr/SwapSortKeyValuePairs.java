package com.ashessin.cs441.hw2.dblp.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.apache.hadoop.fs.CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY;
import static org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setCompressOutput;
import static org.apache.hadoop.mapreduce.lib.output.TextOutputFormat.setOutputCompressorClass;
import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * Swaps Key/Value pairs and then sorts in descending order by the new Key.
 */
public final class SwapSortKeyValuePairs extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(PrimaryFieldCount.class);

    public static void main(String[] args) throws Exception {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new SwapSortKeyValuePairs(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        logger.info("SwapSortKeyValuePairs, Memory used (bytes): {}", memend - memstart);
        logger.info("SwapSortKeyValuePairs, Time taken (ms): {}", end - start);

        // System.exit(res);
    }

    /**
     * Execute the command with the given arguments.
     *
     * @param args command specific arguments.
     * @return exit code.
     * @throws Exception in case of some error
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = super.getConf();
        conf.set("mapreduce.map.output.compress", "true");
        conf.set("mapreduce.output.fileoutputformat.compress.type", "BLOCK");
        conf.set("mapreduce.map.output.compress.codec", "org.apache.hadoop.io.compress.DefaultCodec");

        Path sourceFilePath = new Path(args[0]);
        Path targetDirectoryPath = new Path(args[1]);

        final FileSystem SOURCE_FS = sourceFilePath.getFileSystem(conf);
        final FileSystem TARGET_FS = targetDirectoryPath.getFileSystem(conf);

        logger.info("Source Filesystem is: {}", SOURCE_FS);
        logger.info("Target Filesystem is: {}", TARGET_FS);

        if (SOURCE_FS.getUri() == TARGET_FS.getUri()) {
            conf.set(FS_DEFAULT_NAME_KEY, String.valueOf(TARGET_FS.getUri()));
            logger.info("Setting default filesystem as: {}", conf.get(FS_DEFAULT_NAME_KEY));
        } else {
            logger.warn("The default filesystem is: {}", conf.get(FS_DEFAULT_NAME_KEY));
        }

        // delete existing directory
        if (TARGET_FS.exists(targetDirectoryPath)) {
            TARGET_FS.delete(targetDirectoryPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Swap Sort Key Value Pairs");
        job.setJarByClass(SwapSortKeyValuePairs.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpkSwapSortKeyValuePairsMapper.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setCombinerClass(Reducer.class);
        job.setReducerClass(Reducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        // Sort in descending order by key (count)
        job.setSortComparatorClass(SortIntegerComparator.class);

        FileInputFormat.setInputPaths(job, sourceFilePath);
        FileOutputFormat.setOutputPath(job, targetDirectoryPath);

        setCompressOutput(job, true);
        setOutputCompressorClass(job, GzipCodec.class);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    /**
     * Mapper class to Swaps Key/Value pairs and write to HDFS
     */
    public static class DblpkSwapSortKeyValuePairsMapper extends Mapper<Text, IntWritable, IntWritable, Text> {

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param property set of tab separated {@link com.ashessin.cs441.hw2.dblp.utils.PublicationWritable} field(s)
         *                 for a given DBLP publication record
         * @param count    some number for the given property, ie. set of field(s)
         * @param context  generate an output count/property pair
         */
        @Override
        protected void map(Text property, IntWritable count, Context context) throws IOException, InterruptedException {
            // System.out.println("K: " + property);
            // System.out.println("V: " + count);
            context.write(count, property);
        }
    }

    /**
     * A custom comparator to sort based on the integer value of a key in descending order.
     */
    public static class SortIntegerComparator extends WritableComparator {

        protected SortIntegerComparator() {
            super(IntWritable.class, true);
        }

        /**
         * Compare two WritableComparables.
         *
         * <p> This implementation uses the numerical ordering, calling {@link
         * Comparable#compareTo(Object)}.
         *
         * @param count1 count for property of DBLP publication record A
         * @param count2 count for property of DBLP publication record B
         */
        @Override
        public int compare(WritableComparable count1, WritableComparable count2) {
            IntWritable c1 = (IntWritable) count1;
            IntWritable c2 = (IntWritable) count2;

            return -1 * c1.compareTo(c2);
        }
    }
}
