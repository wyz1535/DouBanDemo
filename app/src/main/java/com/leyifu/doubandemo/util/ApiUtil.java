package com.leyifu.doubandemo.util;

import com.google.gson.GsonBuilder;
import com.leyifu.doubandemo.constant.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xingxing on 2017/9/7.
 */

public class ApiUtil {

    public static Retrofit getRetrofir() {

        return new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
