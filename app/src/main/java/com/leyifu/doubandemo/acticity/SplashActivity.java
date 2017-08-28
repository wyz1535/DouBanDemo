package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.leyifu.doubandemo.R;

public class SplashActivity extends AppCompatActivity {


    public static final String TAG = "SplashActivity";

    private ImageView iv_splash;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initView();
        init();
    }

    private void initView() {
        iv_splash = ((ImageView) findViewById(R.id.iv_splash));
    }

    private void init() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnim01();
            }
        },1000);
    }

    private void startAnim01() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        //是否回到动画前的状态
        scaleAnimation.setFillAfter(true);
        iv_splash.startAnimation(scaleAnimation);

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.e(TAG, "onAnimationStart: " );
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e(TAG, "onAnimationEnd: " );
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e(TAG, "onAnimationRepeat: " );
            }
        });
    }

    private void startAnim() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1.0f);
        alphaAnimation.setDuration(2000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1.0f, 0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        iv_splash.startAnimation(animationSet);
    }
}
