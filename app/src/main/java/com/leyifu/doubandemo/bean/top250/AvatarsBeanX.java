package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class AvatarsBeanX {
    /**
     * large : https://img3.doubanio.com/img/celebrity/large/230.jpg
     * medium : https://img3.doubanio.com/img/celebrity/medium/230.jpg
     * small : https://img3.doubanio.com/img/celebrity/small/230.jpg
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
        return "AvatarsBeanX{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                '}';
    }
}
