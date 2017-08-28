package com.leyifu.doubandemo.acticity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.leyifu.doubandemo.util.ActivityCollectionUtil;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollectionUtil.addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "BaseActivity: "+getClass().getSimpleName() );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectionUtil.removeActivity(this);
    }
}
