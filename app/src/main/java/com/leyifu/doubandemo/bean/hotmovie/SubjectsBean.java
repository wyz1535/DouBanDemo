package com.leyifu.doubandemo.bean.hotmovie;

import java.util.List;

/**
 * Created by xingxing on 2017/8/30.
 */
public class SubjectsBean {
    /**
     * alt : https://movie.douban.com/subject/11502973/
     * casts : [{"alt":"https://movie.douban.com/celebrity/1317646/","avatars":{"large":"https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg","small":"https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg"},"id":"1317646","name":"戴恩·德哈恩"},{"alt":"https://movie.douban.com/celebrity/1326177/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/1365676042.23.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1365676042.23.jpg","small":"https://img3.doubanio.com/img/celebrity/small/1365676042.23.jpg"},"id":"1326177","name":"卡拉·迪瓦伊"},{"alt":"https://movie.douban.com/celebrity/1025147/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/5321.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/5321.jpg","small":"https://img3.doubanio.com/img/celebrity/small/5321.jpg"},"id":"1025147","name":"克里夫·欧文"}]
     * collect_count : 41542
     * directors : [{"alt":"https://movie.douban.com/celebrity/1031876/","avatars":{"large":"https://img3.doubanio.com/img/celebrity/large/33301.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33301.jpg","small":"https://img3.doubanio.com/img/celebrity/small/33301.jpg"},"id":"1031876","name":"吕克·贝松"}]
     * genres : ["动作","科幻","冒险"]
     * id : 11502973
     * images : {"large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2496088130.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2496088130.webp","small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2496088130.webp"}
     * original_title : Valérian and the City of a Thousand Planets
     * rating : {"average":7.1,"max":10,"min":0,"stars":"35"}
     * subtype : movie
     * title : 星际特工：千星之城
     * year : 2017
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
