package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/********
 * Reducer receives the pairs and keeps the best one
 */

public class DistrictMostTreesReducer2 extends Reducer<NullWritable, MapWritable, IntWritable, IntWritable>{
    public void reduce(NullWritable key, Iterable<MapWritable> values, Context context)
            throws IOException, InterruptedException {
        // Stack the iterable to an arraylist 
        ArrayList<Integer[]> nb_trees_by_district = (ArrayList<Integer[]>) StreamSupport.stream(values.spliterator(), false)
                .map( mw ->  (new Integer[] { ((IntWritable) mw.keySet().toArray()[0]).get(), ((IntWritable) mw.get(mw.keySet().toArray()[0])).get() }))
                .collect(Collectors.toList());

        int max_nb_trees = nb_trees_by_district.stream().map((arr) -> arr[1]).max(Integer::compare).get();

        nb_trees_by_district.stream().filter(arr -> arr[1] == max_nb_trees).map(arr -> arr[0]).distinct().forEach((district) -> {
            try {
                context.write(new IntWritable(district),new IntWritable(max_nb_trees));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } });
    }
}