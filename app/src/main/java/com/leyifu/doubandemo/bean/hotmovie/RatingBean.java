package com.leyifu.doubandemo.bean.hotmovie;

/**
 * Created by xingxing on 2017/8/30.
 */
public class RatingBean {
    /**
     * average : 7.1
     * max : 10
     * min : 0
     * stars : 35
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
