package com.leyifu.doubandemo.bean.book;

/**
 * Created by xingxing on 2017/9/12.
 */
public class SeriesBean {
    /**
     * id : 782
     * title : 文化生活译丛（新版）
     */

    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SeriesBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
