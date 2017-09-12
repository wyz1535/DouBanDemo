package com.leyifu.doubandemo.acticity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.CastsDetailAdapter;
import com.leyifu.doubandemo.bean.hotmoviedetail.CastsBean;
import com.leyifu.doubandemo.bean.hotmoviedetail.DirectorsBean;
import com.leyifu.doubandemo.bean.hotmoviedetail.HotMovieDetailBean;
import com.leyifu.doubandemo.bean.hotmoviedetail.MoviePeopleBean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.util.HttpUtil;
import com.leyifu.doubandemo.util.ShowUtil;

import java.io.IOException;
import java.util.ArrayList;
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

    List<MoviePeopleBean> moviePeopleList = new ArrayList<>();

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
                    tv_detail_origin_name.setText(hotMovieDetailBean.getOriginal_title() + "[原名]");
                    tv_detail_introduce.setText(hotMovieDetailBean.getSummary());

                    setListViewAdapter();
                    setListViewHeight(lv_detail_person);
                    //nestedSrollView 嵌套listview，listview自动获取焦点，
                    nestedSrollView.smoothScrollTo(0, 0);
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
    private NestedScrollView nestedSrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detial);

        initView();
        initData();
        init();
        handleMaterialStatusBar();
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
        nestedSrollView = ((NestedScrollView) findViewById(R.id.nestedSrollView));
    }

    private void init() {
        // detail_toolbar.setTitle必须在setSupportActionBar(detail_toolbar)之前调用，否则无效
        detail_toolbar.setTitle("");
        setSupportActionBar(detail_toolbar);

        iv_back.setOnClickListener(this);
        tv_click_more.setOnClickListener(this);
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
                    ShowUtil.toast(MovieDetialActivity.this, "数据错误");
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
                Intent intent = new Intent(MovieDetialActivity.this, WebViewActivity.class);
                intent.putExtra("name", hotMovieDetailBean.getTitle());
                intent.putExtra("alt", hotMovieDetailBean.getAlt());
                startActivity(intent);
                break;
        }
    }

    private void setListViewAdapter() {
        if (hotMovieDetailBean.getDirectors() != null && hotMovieDetailBean.getDirectors().size() != 0) {
            for (int i = 0; i < hotMovieDetailBean.getDirectors().size(); i++) {
                DirectorsBean directorsBean = hotMovieDetailBean.getDirectors().get(i);
                MoviePeopleBean moviePeopleBean = new MoviePeopleBean();
                moviePeopleBean.setAlt(directorsBean.getAlt());
                moviePeopleBean.setAvatars(directorsBean.getAvatars());
                moviePeopleBean.setId(directorsBean.getId());
                moviePeopleBean.setType(1);
                moviePeopleBean.setName(directorsBean.getName());
                moviePeopleList.add(moviePeopleBean);
            }
        }

        if (hotMovieDetailBean.getCasts() != null && hotMovieDetailBean.getCasts().size() > 0) {
            for (int i = 0; i < hotMovieDetailBean.getCasts().size(); i++) {
                CastsBean castsBean = hotMovieDetailBean.getCasts().get(i);
                MoviePeopleBean moviePeopleBean = new MoviePeopleBean();
                moviePeopleBean.setAlt(castsBean.getAlt());
                moviePeopleBean.setAvatars(castsBean.getAvatars());
                moviePeopleBean.setId(castsBean.getId());
                moviePeopleBean.setType(2);
                moviePeopleBean.setName(castsBean.getName());
                moviePeopleList.add(moviePeopleBean);
            }
        }
        lv_detail_person.setAdapter(new CastsDetailAdapter(moviePeopleList));

        lv_detail_person.setOnItemClickListener(moviePeopelItemClick);
    }

    AdapterView.OnItemClickListener moviePeopelItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (moviePeopleList.get(i).getType() == 1) {
            Intent intent = new Intent(MovieDetialActivity.this, WebViewActivity.class);
            intent.putExtra("name", moviePeopleList.get(i).getName());
            intent.putExtra("alt", moviePeopleList.get(i).getAlt());
            startActivity(intent);
//                } else if (moviePeopleList.get(i).getType() == 2) {
//
//                }
        }
    };

    public static void setListViewHeight(ListView listView) {
        if (listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
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
