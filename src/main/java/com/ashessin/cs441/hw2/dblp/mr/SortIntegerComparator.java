package com.ashessin.cs441.hw2.dblp.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SortIntegerComparator extends WritableComparator {

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
