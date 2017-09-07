package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class DirectorsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1047973/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg","small":"https://img3.doubanio.com/img/celebrity/small/230.jpg"}
     * id : 1047973
     * name : 弗兰克·德拉邦特
     */

    private String alt;
    private AvatarsBeanX avatars;
    private String id;
    private String name;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBeanX getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBeanX avatars) {
        this.avatars = avatars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DirectorsBean{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
