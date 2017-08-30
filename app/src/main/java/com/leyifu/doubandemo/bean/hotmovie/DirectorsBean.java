package com.leyifu.doubandemo.bean.hotmovie;

/**
 * Created by xingxing on 2017/8/30.
 */
public class DirectorsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1031876/
     * avatars : {"large":"https://img3.doubanio.com/img/celebrity/large/33301.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33301.jpg","small":"https://img3.doubanio.com/img/celebrity/small/33301.jpg"}
     * id : 1031876
     * name : 吕克·贝松
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
         * large : https://img3.doubanio.com/img/celebrity/large/33301.jpg
         * medium : https://img3.doubanio.com/img/celebrity/medium/33301.jpg
         * small : https://img3.doubanio.com/img/celebrity/small/33301.jpg
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
