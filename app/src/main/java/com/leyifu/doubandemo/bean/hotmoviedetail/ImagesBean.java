package com.leyifu.doubandemo.bean.hotmoviedetail;

/**
 * Created by xingxing on 2017/8/31.
 */
public class ImagesBean {
    /**
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2494950714.webp
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2494950714.webp
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2494950714.webp
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
}
