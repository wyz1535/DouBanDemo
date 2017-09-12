package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class AvatarsBean {
    /**
     * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
     * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
     * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
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
        return "AvatarsBean{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                '}';
    }
}
