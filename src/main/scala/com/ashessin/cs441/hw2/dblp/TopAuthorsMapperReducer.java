package com.ashessin.cs441.hw2.dblp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;

public class TopAuthorsMapperReducer extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new TopAuthorsMapperReducer(), args);
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

        Job job = Job.getInstance(conf, "Dblp Top Authors");
        job.setJarByClass(TopAuthorsMapperReducer.class);
        job.setMapperClass(DblpMapper.class);
        job.setCombinerClass(DblpReducer.class);
        job.setReducerClass(DblpReducer.class);
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

        private final static IntWritable ONE = new IntWritable(1);
        private Text author = new Text();

        /**
         * Called once for each key/value pair in the input split.
         *
         * @param key
         * @param publication
         * @param context
         */
        protected void map(Text key, PublicationWritable publication, Context context) throws IOException, InterruptedException {
            Iterator<String> authorIterator = publication.getAuthors().iterator();
            while (authorIterator.hasNext()) {
                author.set(authorIterator.next());
                context.write(author, ONE);
            }
        }
    }

    public static class DblpReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        private IntWritable result = new IntWritable();

        /**
         * This method is called once for each key.
         *
         * @param author
         * @param values
         * @param context
         */
        protected void reduce(Text author, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(author, result);
        }
    }

    // TODO: Sort by values
}
