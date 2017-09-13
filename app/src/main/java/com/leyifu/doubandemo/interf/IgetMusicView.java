package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.music.MusicBean;

/**
 * Created by xingxing on 2017/9/13.
 */

public interface IgetMusicView {

    void onMusicSuccess(MusicBean musicBean,boolean isLoadMore);

    void onFaild();
}
