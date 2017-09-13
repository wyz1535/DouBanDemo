package com.leyifu.doubandemo.interf;

import com.leyifu.doubandemo.bean.book.BookBean;
import com.leyifu.doubandemo.bean.book.BooksBean;
import com.leyifu.doubandemo.bean.top250.Top250Bean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xingxing on 2017/9/7.
 */

public interface DouBanApi {

    @GET("v2/movie/top250")
    Observable<Top250Bean> getTop250Movie(@Query("start") int start, @Query("count") int count);

    @GET("v2/book/search")
    Observable<BookBean> getBook(@Query("tag") String tag,@Query("start") int start, @Query("count") int count);

    @GET("v2/book/{id}")
    Observable<BooksBean> getBookDetail(@Path("id") String id);

}
