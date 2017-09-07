package com.leyifu.doubandemo.bean.top250;

import java.util.List;

/**
 * Created by xingxing on 2017/9/3.
 */
public class SubjectsBean {
    /**
     * alt : https://movie.douban.com/subject/1292052/
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg","small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg"},"id":"1054521","name":"蒂姆·罗宾斯"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg","small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg"},"id":"1054534","name":"摩根·弗里曼"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg","small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg"},"id":"1041179","name":"鲍勃·冈顿"}]
     * collect_count : 1114931
     * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg","small":"https://img3.doubanio.com/img/celebrity/small/230.jpg"},"id":"1047973","name":"弗兰克·德拉邦特"}]
     * genres : ["犯罪","剧情"]
     * id : 1292052
     * images : {"large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.webp","small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.webp"}
     * original_title : The Shawshank Redemption
     * rating : {"average":9.6,"max":10,"min":0,"stars":"50"}
     * subtype : movie
     * title : 肖申克的救赎
     * year : 1994
     */

    private String alt;
    private int collect_count;
    private String id;
    private ImagesBean images;
    private String original_title;
    private RatingBean rating;
    private String subtype;
    private String title;
    private String year;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> genres;

    @Override
    public String toString() {
        return "SubjectsBean{" +
                "alt='" + alt + '\'' +
                ", collect_count=" + collect_count +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", original_title='" + original_title + '\'' +
                ", rating=" + rating +
                ", subtype='" + subtype + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", casts=" + casts +
                ", directors=" + directors +
                ", genres=" + genres +
                '}';
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}
