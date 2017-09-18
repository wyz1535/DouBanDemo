package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.util.ActivityCollectionUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExitLogInActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.detail_toolbar)
    Toolbar detailToolbar;
    @BindView(R.id.bt_exit_land_regist)
    Button btExitLandRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_log_in);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.bt_exit_land_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_exit_land_regist:
                ActivityCollectionUtil.finishAll();
                SharedPreferences.Editor editor = PreferenceManager
                        .getDefaultSharedPreferences(ExitLogInActivity.this)
                        .edit();
                editor.putString("name", "");
                editor.putString("password", "");
                editor.apply();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
