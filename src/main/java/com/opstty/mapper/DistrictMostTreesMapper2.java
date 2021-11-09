package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/*******************************************************************************
 *
 * Mapper retrieves the pairs (district, number) from the first phase, and makes
 * them pairs whose key is unimportant (NullWritable) and the values themselves
 * are the same input pairs.

 *******************************************************************************/

public class DistrictMostTreesMapper2 extends Mapper<Object, Text, NullWritable, MapWritable>{
    public int curr_line = 0;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (curr_line != 0) {
            try {
                MapWritable map = new MapWritable();
                map.put(value, new IntWritable(1));
                context.write(NullWritable.get(), map);
            }
            // The year has to be an integer
            catch (NumberFormatException ex) {
            }
        } curr_line++;
    }
}