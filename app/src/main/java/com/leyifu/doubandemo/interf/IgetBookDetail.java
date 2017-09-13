package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.book.BooksBean;

/**
 * Created by hahaha on 2017/9/13 0013.
 */

public interface IgetBookDetail {

    void onBookDetailSuccess(BooksBean booksBean);

    void  onBookDetailFaild();

}
