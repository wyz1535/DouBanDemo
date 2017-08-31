package com.leyifu.doubandemo.bean.hotmoviedetail;

/**
 * Created by xingxing on 2017/8/31.
 */
public class DirectorsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1054524/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/673.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/673.jpg","small":"https://img3.doubanio.com/img/celebrity/small/673.jpg"}
     * id : 1054524
     * name :
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

    public static class AvatarsBeanX {
        /**
         * large : https://img3.doubanio.com/img/celebrity/large/673.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/673.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/673.jpg
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
}
