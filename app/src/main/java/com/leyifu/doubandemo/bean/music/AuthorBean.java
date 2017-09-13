package com.leyifu.doubandemo.bean.music;

/**
 * Created by xingxing on 2017/9/13.
 */
public class AuthorBean {
    /**
     * name : 周杰伦
     */

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
