package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.top250.Top250Bean;

/**
 * Created by xingxing on 2017/9/11.
 */

public interface IgetTop250View {

    void getTop250Success(Top250Bean top250Bean, boolean isLoadMore);

    void getTopFaild();
}
