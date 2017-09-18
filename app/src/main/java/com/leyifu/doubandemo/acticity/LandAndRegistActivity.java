package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hahaha on 2017/3/13 0013.
 */
public class LandAndRegistActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LandAndRegistActivity";
    private static final int ISSUCCESS = 0;
    private Button bt_land_regist;
    private TextView tv_new_user_regist;
    private EditText et_land_name;
    private EditText et_land_password;
    private TextView tv_forget_password;
    private ImageView iv_land_more_name_down;
    private RelativeLayout rl_account;
    private String LOG_IN_URL = "http://www.otooman.com/ajaxLogin.htm";
    Map<String, String> landMap = new HashMap<String, String>();

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case ISSUCCESS:
                    String message = (String) msg.obj;
                    if (message.contains("成功")) {
                        Toast.makeText(LandAndRegistActivity.this, "登陆成功",
                                Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = PreferenceManager
                                .getDefaultSharedPreferences(LandAndRegistActivity.this)
                                .edit();
                        editor.putString("name", name);
                        editor.putString("password", password);
                        editor.apply();
                        Intent mainIntent = new Intent(LandAndRegistActivity.this,
                                MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    } else if (message.contains("错误")) {
                        Toast.makeText(LandAndRegistActivity.this, "密码错误",
                                Toast.LENGTH_SHORT).show();
                    } else if (message.contains("不存在")) {
                        Toast.makeText(LandAndRegistActivity.this, "用户名不存在",
                                Toast.LENGTH_SHORT).show();
                    } else if (message.contains("繁忙")) {
                        Toast.makeText(LandAndRegistActivity.this, "系统繁忙，请稍后再试",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };
    private String name;
    private String password;
    private ImageView iv_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_regist);

        initUI();
        init();
    }

    private void initUI() {
        bt_land_regist = ((Button) findViewById(R.id.bt_land_regist));
        iv_back = ((ImageView) findViewById(R.id.iv_back));
//        tv_new_user_regist = ((TextView) findViewById(R.id.tv_new_user_regist));
        et_land_name = ((EditText) findViewById(R.id.et_land_name));
        et_land_password = ((EditText) findViewById(R.id.et_land_password));
//        tv_forget_password = ((TextView) findViewById(R.id.tv_forget_password));
        rl_account = ((RelativeLayout) findViewById(R.id.rl_account));
    }

    private void init() {
//        tv_new_user_regist.setOnClickListener(this);
        bt_land_regist.setOnClickListener(this);
//        tv_forget_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_land_regist:
                name = et_land_name.getText().toString().trim();
                password = et_land_password.getText().toString().trim();
                String landName = null;
                String landPassword = null;

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(LandAndRegistActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LandAndRegistActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                landMap.put("username", name);
                landMap.put("password", password);
                landMap.put("isMobile", "1");
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String submitPostData = HttpUtil.submitPostData(LOG_IN_URL,
                                landMap, "UTF-8");
                        if (submitPostData != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(submitPostData);
                                String msg = jsonObject.getString("message");
                                Message message = handler.obtainMessage();
                                message.what = ISSUCCESS;
                                message.obj = msg;
                                handler.sendMessage(message);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
                break;


        }
    }

}
