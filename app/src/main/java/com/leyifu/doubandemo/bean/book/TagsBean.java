package com.leyifu.doubandemo.bean.book;

/**
 * Created by xingxing on 2017/9/12.
 */
public class TagsBean {
    /**
     * count : 363
     * name : 德国
     * title : 德国
     */

    private int count;
    private String name;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TagsBean{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
