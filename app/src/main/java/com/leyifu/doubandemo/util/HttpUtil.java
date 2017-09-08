package com.leyifu.doubandemo.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by xingxing on 2017/8/29.
 */
public class HttpUtil {

    public static void sendHttpRequest(String adress, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(adress).build();
        client.newCall(request).enqueue(callback);
    }
}
