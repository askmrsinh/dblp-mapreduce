package com.ashessin.cs441.hw2.dblp.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class FilterHorizontally extends CompositeCount {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new FilterHorizontally(), args);
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
        conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", "\t\t");
        conf.set(TextOutputFormat.SEPARATOR, "\t\t");

        final String HDFS = "hdfs://localhost:9000";
        Path inputFile = new Path(new URI(HDFS + args[0]));
        Path outputPath = new Path(new URI(HDFS + args[1]));
        DblpCompositeCountMapper.setRequiredFields(args[2]);

        FileSystem hdfs = FileSystem.get(URI.create(HDFS), conf);
        // delete existing directory
        if (hdfs.exists(outputPath)) {
            hdfs.delete(outputPath, true);
        }

        Job job = Job.getInstance(conf, "Dblp Filter Horizontally");
        job.setJarByClass(CompositeCount.class);
        job.setMapperClass(Mapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setReducerClass(DblpFilterHorizontallyReducer.class);
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpFilterHorizontallyReducer extends Reducer<Text, Text, Text, IntWritable> {

        private IntWritable result = new IntWritable();

        /**
         * This method is called once for each key.
         *
         * @param tag
         * @param values
         * @param context
         */
        @Override
        protected void reduce(Text tag, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            // System.out.println("TAG: " + tag);
            LinkedHashSet fields = new LinkedHashSet(Arrays.asList(tag.toString().split("\t")));
            // write only if all fields are unique (horizontally)
            if (fields.size() == DblpCompositeCountMapper.getRequiredFields().length) {
                for (Text val : values) {
                    // System.out.println("VAL: " + val);
                    sum += Integer.parseInt(val.toString());
                }
                result.set(sum);
                context.write(tag, result);
            }
        }
    }
}
