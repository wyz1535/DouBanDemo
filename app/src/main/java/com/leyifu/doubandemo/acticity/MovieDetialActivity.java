package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.CastsDetailAdapter;
import com.leyifu.doubandemo.bean.hotmoviedetail.HotMovieDetailBean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.util.HttpUtil;
import com.leyifu.doubandemo.util.ShowUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MovieDetialActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MovieDetialActivity";
    private static final int SUCCEED = 0;
    private static final int FAILD = 1;
    private Toolbar detail_toolbar;
    private TextView tv_toolbar_title;
    private ImageView iv_back;
    private ImageView iv_detail_poster;
    private TextView tv_detail_score;
    private TextView tv_detail_review;
    private TextView tv_detail_year;
    private TextView tv_detail_story;
    private TextView tv_detail_county;
    private TextView tv_detail_origin_name;
    private TextView tv_detail_introduce;
    private ListView lv_detail_person;
    private TextView tv_click_more;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCEED:
                    hotMovieDetailBean = (HotMovieDetailBean) msg.obj;
                    tv_toolbar_title.setText(hotMovieDetailBean.getTitle());
                    Glide.with(MovieDetialActivity.this).load(hotMovieDetailBean.getImages().getLarge()).into(iv_detail_poster);
                    tv_detail_score.setText("评分" + hotMovieDetailBean.getRating().getAverage());
                    tv_detail_review.setText(hotMovieDetailBean.getRatings_count() + "人评论");
                    tv_detail_year.setText(hotMovieDetailBean.getYear() + "  出品");
                    List<String> genres = hotMovieDetailBean.getGenres();
                    StringBuilder builder = new StringBuilder();
                    StringBuilder strCountries = new StringBuilder();
                    for (int i = 0; i < genres.size(); i++) {
                        if (i != genres.size() - 1) {
                            builder.append(genres.get(i) + "/");
                        } else {
                            builder.append(genres.get(i));
                        }
                    }
                    tv_detail_story.setText(builder);

                    List<String> countries = hotMovieDetailBean.getCountries();
                    for (int i = 0; i < countries.size(); i++) {
                        if (i != countries.size() - 1) {
                            strCountries.append(countries.get(i) + "/");
                        } else {
                            strCountries.append(countries.get(i));
                        }
                    }
                    tv_detail_county.setText(strCountries);
                    tv_detail_origin_name.setText(hotMovieDetailBean.getOriginal_title()+"[原名]");
                    tv_detail_introduce.setText(hotMovieDetailBean.getSummary());
                    lv_detail_person.setAdapter(new CastsDetailAdapter(hotMovieDetailBean.getCasts()));
                    break;
                case FAILD:
                    ShowUtil.toast(MovieDetialActivity.this, "请求数据失败");
                    break;
            }
        }
    };
    private ImageView iv_item_poster;
    private TextView tv_item_casts_name;
    private TextView tv_item_casts_type;
    private HotMovieDetailBean hotMovieDetailBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detial);

        initView();
        initData();
        init();
    }

    private void initView() {
        detail_toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        tv_toolbar_title = ((TextView) findViewById(R.id.tv_toolbar_title));
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        iv_detail_poster = ((ImageView) findViewById(R.id.iv_detail_poster));
        tv_detail_score = ((TextView) findViewById(R.id.tv_detail_score));
        tv_detail_review = ((TextView) findViewById(R.id.tv_detail_review));
        tv_detail_year = ((TextView) findViewById(R.id.tv_detail_year));
        tv_detail_story = ((TextView) findViewById(R.id.tv_detail_story));
        tv_detail_county = ((TextView) findViewById(R.id.tv_detail_county));
        tv_detail_origin_name = ((TextView) findViewById(R.id.tv_detail_origin_name));
        tv_detail_introduce = ((TextView) findViewById(R.id.tv_detail_introduce));
        lv_detail_person = ((ListView) findViewById(R.id.lv_detail_person));
        tv_click_more = ((TextView) findViewById(R.id.tv_click_more));
    }

    private void init() {
        // detail_toolbar.setTitle必须在setSupportActionBar(detail_toolbar)之前调用，否则无效
        detail_toolbar.setTitle("");
        setSupportActionBar(detail_toolbar);

        iv_back.setOnClickListener(this);
        tv_click_more.setOnClickListener(this);

//        View head = View.inflate(this, R.layout.item_movie_detail, null);
//        iv_item_poster = ((ImageView) head.findViewById(R.id.iv_item_poster));
//        tv_item_casts_name = ((TextView) head.findViewById(R.id.tv_item_casts_name));
//        tv_item_casts_type = ((TextView) head.findViewById(R.id.tv_item_casts_type));
//        Glide.with(this).load(hotMovieDetailBean.getDirectors().get(0).getAvatars().getLarge());
//        tv_item_casts_name.setText(hotMovieDetailBean.getDirectors().get(0).getName());
//        tv_item_casts_type.setText("[导演]");
//        lv_detail_person.addHeaderView(head);

    }

    private void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String url = Constants.URL + "v2/movie/subject/" + id;
        HttpUtil.sendHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(FAILD);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                HotMovieDetailBean hotMovieDetailBean = new Gson().fromJson(body, HotMovieDetailBean.class);
                if (hotMovieDetailBean != null) {
                    Message message = handler.obtainMessage();
                    message.what = SUCCEED;
                    message.obj = hotMovieDetailBean;
                    handler.sendMessage(message);
                } else {
                    ShowUtil.toast(MovieDetialActivity.this,"数据错误");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_click_more:
                break;
        }
    }
}
