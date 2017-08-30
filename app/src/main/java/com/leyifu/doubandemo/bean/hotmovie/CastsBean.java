package com.leyifu.doubandemo.bean.hotmovie;

/**
 * Created by xingxing on 2017/8/30.
 */
public class CastsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1317646/
     * avatars : {"large":"https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg","small":"https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg"}
     * id : 1317646
     * name : 戴恩·德哈恩
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

    public static class AvatarsBean {
        /**
         * large : https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg
         * medium : https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg
         * small : https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg
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
