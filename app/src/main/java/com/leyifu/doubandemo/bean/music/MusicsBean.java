package com.leyifu.doubandemo.bean.music;

import java.util.List;

/**
 * Created by xingxing on 2017/9/13.
 */
public class MusicsBean {

    private RatingBean rating;
    private String alt_title;
    private String image;
    private String mobile_link;
    private AttrsBean attrs;
    private String title;
    private String alt;
    private String id;
    private List<AuthorBean> author;
    private List<TagsBean> tags;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public void setMobile_link(String mobile_link) {
        this.mobile_link = mobile_link;
    }

    public AttrsBean getAttrs() {
        return attrs;
    }

    public void setAttrs(AttrsBean attrs) {
        this.attrs = attrs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AuthorBean> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBean> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "MusicsBean{" +
                "rating=" + rating +
                ", alt_title='" + alt_title + '\'' +
                ", image='" + image + '\'' +
                ", mobile_link='" + mobile_link + '\'' +
                ", attrs=" + attrs +
                ", title='" + title + '\'' +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                '}';
    }
}
