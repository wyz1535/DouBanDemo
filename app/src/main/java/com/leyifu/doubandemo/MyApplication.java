package com.leyifu.doubandemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by hahaha on 2017/9/14 0014.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
