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

import java.io.IOException;
import java.net.URI;

import static org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setCompressOutput;
import static org.apache.hadoop.mapreduce.lib.output.TextOutputFormat.setOutputCompressorClass;

public class SwapKeyVal extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new SwapKeyVal(), args);
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

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Swap Key Value pairs");
        job.setJarByClass(SwapKeyVal.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setMapperClass(DblpkInversMapper.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setCombinerClass(Reducer.class);
        job.setReducerClass(Reducer.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        // Sort in descending order by key (count)
        job.setSortComparatorClass(SortIntegerComparator.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        setCompressOutput(job, true);
        setOutputCompressorClass(job, GzipCodec.class);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpkInversMapper extends Mapper<Text, IntWritable, IntWritable, Text> {

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param k
         * @param v
         * @param context
         */
        @Override
        protected void map(Text k, IntWritable v, Context context) throws IOException, InterruptedException {
            // System.out.println("K: " + k);
            // System.out.println("V: " + v);
            context.write(v, k);
        }
    }

    public static class SortIntegerComparator extends WritableComparator {

        protected SortIntegerComparator() {
            super(IntWritable.class, true);
        }

        /**
         * Compare two WritableComparables.
         *
         * <p> The default implementation uses the natural ordering, calling {@link
         * Comparable#compareTo(Object)}.
         *
         * @param a
         * @param b
         */
        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            IntWritable k1 = (IntWritable) a;
            IntWritable k2 = (IntWritable) b;

            return -1 * k1.compareTo(k2);
        }
    }
}
