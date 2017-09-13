package com.leyifu.doubandemo.bean.music;

/**
 * Created by xingxing on 2017/9/13.
 */
public class TagsBean {
    /**
     * count : 17485
     * name : 周杰伦
     */

    private int count;
    private String name;

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

    @Override
    public String toString() {
        return "TagsBean{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
