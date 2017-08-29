package com.leyifu.doubandemo.acticity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.util.ActivityCollectionUtil;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleMaterialStatusBar();
        ActivityCollectionUtil.addActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "BaseActivity: "+getClass().getSimpleName() );
    }

    /**
     * 适配沉浸状态栏
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void handleMaterialStatusBar() {
        // Not supported in APK level lower than 21
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return;

        Window window = this.getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(getResources().getColor(R.color.colorAccent));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectionUtil.removeActivity(this);
    }
}
