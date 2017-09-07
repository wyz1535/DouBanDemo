package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class RatingBean {
    @Override
    public String toString() {
        return "RatingBean{" +
                "average=" + average +
                ", max=" + max +
                ", min=" + min +
                ", stars='" + stars + '\'' +
                '}';
    }

    /**
     * average : 9.6
     * max : 10
     * min : 0
     * stars : 50
     */



    private double average;
    private int max;
    private int min;
    private String stars;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
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

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
}
