package dblp.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.net.URI;

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

        Path inputFile = new Path(new URI("hdfs://localhost:9000" + args[0]));
        Path outputPath = new Path(new URI("hdfs://localhost:9000" + args[1]));

        Job job = Job.getInstance(conf, "Swap Key Value pairs");
        job.setJarByClass(SwapKeyVal.class);
        job.setMapperClass(DblpMapper.class);
        job.setReducerClass(Reducer.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setSortComparatorClass(SortIntegerComparator.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, inputFile);
        FileOutputFormat.setOutputPath(job, outputPath);

        if (job.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static class DblpMapper extends Mapper<Text, Text, IntWritable, Text> {

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param k
         * @param v
         * @param context
         */
        protected void map(Text k, Text v, Context context) throws IOException, InterruptedException {
            IntWritable value = new IntWritable(Integer.parseInt(v.toString()));
            context.write(value, k);
        }
    }
}
