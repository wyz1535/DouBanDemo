package com.leyifu.doubandemo.bean.music;

import java.util.List;

/**
 * Created by xingxing on 2017/9/13.
 */

public class MusicBean {

    private int count;
    private int start;
    private int total;
    private List<MusicsBean> musics;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MusicsBean> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicsBean> musics) {
        this.musics = musics;
    }

    @Override
    public String toString() {
        return "MusicBean{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", musics=" + musics +
                '}';
    }
}
