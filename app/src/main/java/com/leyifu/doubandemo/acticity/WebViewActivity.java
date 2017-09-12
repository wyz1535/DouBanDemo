package com.leyifu.doubandemo.acticity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leyifu.doubandemo.R;

public class WebViewActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar detail_toolbar;
    private ImageView iv_back;
    private WebView web_view;
    private TextView tv_toolbar_title;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initView();
        init();

        handleMaterialStatusBar();
    }

    private void initView() {
        detail_toolbar = ((Toolbar) findViewById(R.id.detail_toolbar));
        tv_toolbar_title = ((TextView) findViewById(R.id.tv_toolbar_title));
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        web_view = ((WebView) findViewById(R.id.web_view));
        progress_bar = ((ProgressBar) findViewById(R.id.progress_bar));
    }

    private void init() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String alt = intent.getStringExtra("alt");

        iv_back.setOnClickListener(this);

        detail_toolbar.setTitle("");
        setSupportActionBar(detail_toolbar);
        tv_toolbar_title.setText(name);

        initWeb(alt);
    }

    private void initWeb(String url) {
        WebSettings webSettings = web_view.getSettings();

        webSettings.setJavaScriptEnabled(true);   //支持js

        webSettings.setSupportZoom(true);  //支持缩放

        web_view.loadUrl(url);
        web_view.setWebChromeClient(webChromeClient);
        web_view.setWebViewClient(new WebViewClient());
    }
        WebChromeClient webChromeClient = new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress < 100) {
                    progress_bar.setVisibility(View.VISIBLE);
                } else {
                    progress_bar.setVisibility(View.GONE);
                }
            }
        };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
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

        window.setStatusBarColor(getResources().getColor(R.color.colorAccent02));

    }
}
