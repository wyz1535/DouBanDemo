package com.leyifu.doubandemo.bean.book;

/**
 * Created by xingxing on 2017/9/12.
 */
public class RatingBean {
    /**
     * average : 8.2
     * max : 10
     * min : 0
     * numRaters : 938
     */

    private String average;
    private int max;
    private int min;
    private int numRaters;

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

    @Override
    public String toString() {
        return "RatingBean{" +
                "average='" + average + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", numRaters=" + numRaters +
                '}';
    }
}
