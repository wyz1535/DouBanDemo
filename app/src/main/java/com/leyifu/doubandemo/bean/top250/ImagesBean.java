package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class ImagesBean {
    /**
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.webp
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.webp
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.webp
     */

    private String large;
    private String medium;
    private String small;

    @Override
    public String toString() {
        return "ImagesBean{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", small='" + small + '\'' +
                '}';
    }

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
}
