package com.ashessin.cs441.hw2.dblp.mr;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.apache.hadoop.fs.CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY;
import static org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setOutputCompressorClass;
import static org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat.setOutputCompressionType;
import static org.apache.log4j.PropertyConfigurator.configure;

/**
 * Counts the first field value in a field value set.
 */
public final class PrimaryFieldCount extends Configured implements Tool {
    private static final Logger logger = LoggerFactory.getLogger(PrimaryFieldCount.class);

    public static void main(String[] args) throws Exception {
        configure(Thread.currentThread().getContextClassLoader().getResource("log4j.properties"));
        long start = System.currentTimeMillis();
        long memstart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int res = ToolRunner.run(new Configuration(), new PrimaryFieldCount(), args);

        long memend = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long end = System.currentTimeMillis();

        logger.info("PrimaryFieldCount, Memory used (bytes): {}", memend - memstart);
        logger.info("PrimaryFieldCount, Time taken (ms): {}", end - start);

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

        Job job = Job.getInstance(conf, "Dblp Primary Field Count");
        job.setJarByClass(PrimaryFieldCount.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpPrimaryFieldCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        FileInputFormat.setInputPaths(job, sourceFilePath);
        FileOutputFormat.setOutputPath(job, targetDirectoryPath);

        setOutputCompressionType(job, SequenceFile.CompressionType.BLOCK);
        setOutputCompressorClass(job, DefaultCodec.class);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpPrimaryFieldCountMapper extends Mapper<Text, IntWritable, Text, IntWritable> {

        private static final IntWritable ONE = new IntWritable(1);
        private Text result = new Text();

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param field1  the first field value in a tab separated field value string
         * @param count   the count for joined field value string
         * @param context generate an output result/1 pair
         */
        @Override
        protected void map(Text field1, IntWritable count, Context context) throws IOException, InterruptedException {
            String primaryKey = field1.toString().split("\t")[0];
            if (primaryKey.length() > 0) {
                result.set(primaryKey);
                context.write(result, ONE);
            }
        }
    }
}
