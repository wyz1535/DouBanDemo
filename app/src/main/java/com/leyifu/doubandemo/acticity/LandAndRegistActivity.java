package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leyifu.doubandemo.R;

/**
 * Created by hahaha on 2017/3/13 0013.
 */
public class LandAndRegistActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LandAndRegistActivity";
    private Button bt_land_regist;
    private TextView tv_new_user_regist;
    private EditText et_land_name;
    private EditText et_land_password;
    private TextView tv_forget_password;
    private ImageView iv_land_more_name_down;
    private RelativeLayout rl_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_regist);

        initUI();
        init();
    }

    private void initUI() {
        bt_land_regist = ((Button) findViewById(R.id.bt_land_regist));
        tv_new_user_regist = ((TextView) findViewById(R.id.tv_new_user_regist));
        et_land_name = ((EditText) findViewById(R.id.et_land_name));
        et_land_password = ((EditText) findViewById(R.id.et_land_password));
        tv_forget_password = ((TextView) findViewById(R.id.tv_forget_password));
        rl_account = ((RelativeLayout) findViewById(R.id.rl_account));
    }

    private void init() {
        tv_new_user_regist.setOnClickListener(this);
        bt_land_regist.setOnClickListener(this);
        tv_forget_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_new_user_regist:
//                Intent registIntent = new Intent(LandAndRegistActivity.this, RegistActivity.class);
//                startActivity(registIntent);
                break;
            case R.id.bt_land_regist:
                String name = et_land_name.getText().toString().trim();
                String password = et_land_password.getText().toString().trim();
                String landName = null;
                String landPassword = null;

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(LandAndRegistActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LandAndRegistActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if ((name).equals(landName) && (password.equals(landPassword))) {
                    Intent mainIntent = new Intent(LandAndRegistActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    Toast.makeText(LandAndRegistActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(LandAndRegistActivity.this, "账号密码不正确", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tv_forget_password:
                Toast.makeText(LandAndRegistActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
