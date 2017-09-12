package com.leyifu.doubandemo.bean.top250;

/**
 * Created by xingxing on 2017/9/3.
 */
public class CastsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1054521/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg","small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg"}
     * id : 1054521
     * name : 蒂姆·罗宾斯
     */

    private String alt;
    private AvatarsBean avatars;
    private String id;
    private String name;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
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
        return "CastsBean{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
