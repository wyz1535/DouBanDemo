package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.book.BookBean;

/**
 * Created by xingxing on 2017/9/12.
 */

public interface IgetBookView {

    void onBookSuccess(BookBean bookBean,boolean isLoadMore);

    void onBookFailed();
}
