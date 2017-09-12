package com.leyifu.doubandemo.bean.hotmoviedetail;

/**
 * Created by xingxing on 2017/8/31.
 */
public class CastsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1355522/
     * avatars : {"large":"https://img1.doubanio.com/img/celebrity/large/1494157438.59.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1494157438.59.jpg","small":"https://img1.doubanio.com/img/celebrity/small/1494157438.59.jpg"}
     * id : 1355522
     * name :
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

}
