package com.opstty.job;

import com.opstty.mapper.DistrictMostTreesMapper;
import com.opstty.mapper.HighestTreeByKindMapper;
import com.opstty.reducer.DistrictMostTreesReducer;
import com.opstty.reducer.HighestTreeByKindReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictMostTrees {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: districtMostTrees <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "districtMostTrees");
        job.setJarByClass(DistrictMostTrees.class);

        // Two MapReduce phases =>


        // 1) Mapper1 : distinct district / arrondissement ; Reducer1 : (district, nb_district)
        //retrieves the distinctDistrict reducer (TreesReducer) output (pair of (district, nb_trees) => DistinctDistricts
        job.setMapperClass(DistrictMostTreesMapper.class);
        job.setCombinerClass(DistrictMostTreesReducer.class);
        job.setReducerClass(DistrictMostTreesReducer.class);

        // 2) Mapper2 : takes in input Reducer1 => outputs pairs with Null keys ; Reducer2 : outputs the best pair
        // Reducer input : (district, nb_trees) with NullWritable keys
        /*job.setMapperClass(DistrictMostTreesMapper.class);
        job.setCombinerClass(DistrictMostTreesReducer.class);
        job.setReducerClass(DistrictMostTreesReducer.class);*/

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
