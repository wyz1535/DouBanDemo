package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.music.MusicsBean;

/**
 * Created by hahaha on 2017/9/15 0015.
 */

public interface IgetMusicDetailView {

    void onMusicDetailSuccess(MusicsBean MusicsBean);

    void onMusicDetailFaild();
}
