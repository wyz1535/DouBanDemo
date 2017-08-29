package com.leyifu.doubandemo.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hahaha on 2017/8/29 0029.
 */

public class ShowUtil {

    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;
    private static final int level = VERBOSE;

    public static void v(String TAG, String msg) {
        if (level <= VERBOSE) {
            Log.v(TAG, "msg" + msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (level <= DEBUG) {
            Log.v(TAG, "msg" + msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (level <= INFO) {
            Log.v(TAG, "msg" + msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (level <= WARN) {
            Log.v(TAG, "msg" + msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (level <= ERROR) {
            Log.v(TAG, "msg" + msg);
        }
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//        if (toast != null) {
//            toast.show();
//        }
    }
}
