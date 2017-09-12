package com.leyifu.doubandemo.bean.book;

/**
 * Created by xingxing on 2017/9/12.
 */
public class ImagesBean {
    /**
     * large : https://img1.doubanio.com/lpic/s2619459.jpg
     * medium : https://img1.doubanio.com/mpic/s2619459.jpg
     * small : https://img1.doubanio.com/spic/s2619459.jpg
     */

    private String large;
    private String medium;
    private String small;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "ImagesBean{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                '}';
    }
}
