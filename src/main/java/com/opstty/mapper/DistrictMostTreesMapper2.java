package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/*******************************************************************************
 *
 * Mapper retrieves the pairs (district, number) from the first phase, and makes
 * them pairs whose key is unimportant (NullWritable) and the values themselves
 * are the same input pairs.

 *******************************************************************************/

public class DistrictMostTreesMapper2 extends Mapper<Object, Text, IntWritable, IntWritable> {
    public int curr_line = 0;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (curr_line != 0) {
            try {
                context.write(new IntWritable(Integer.parseInt(value.toString().split(";")[1])), new IntWritable(1));
            } catch (NumberFormatException | IOException ex) {
                System.err.println("error from the parseFloat() method");
            }
        }
        curr_line++;
    }
}
