package com.leyifu.doubandemo.acticity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.bean.music.MusicsBean;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetMusicDetailView;
import com.leyifu.doubandemo.presenter.DouBanPersenter;
import com.leyifu.doubandemo.util.ShowUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Music01DetailsActivity extends BaseActivity implements View.OnClickListener, IgetMusicDetailView {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.detail_toolbar)
    Toolbar detailToolbar;
    @BindView(R.id.iv_detail_head)
    ImageView ivDetailHead;
    @BindView(R.id.tv_detail_name)
    TextView tvDetailName;
    @BindView(R.id.tv_detail_score)
    TextView tvDetailScore;
    @BindView(R.id.tv_detail_author)
    TextView tvDetailAuthor;
    @BindView(R.id.tv_detail_want_look)
    TextView tvDetailWantLook;
    @BindView(R.id.tv_detail_look_details)
    TextView tvDetailLookDetails;
    @BindView(R.id.tv_detail_book_intro)
    TextView tvDetailBookIntro;
    @BindView(R.id.tv_detail_author_intro)
    TextView tvDetailAuthorIntro;
    @BindView(R.id.tv_detail_book_info)
    TextView tvDetailBookInfo;
    @BindView(R.id.tv_detail_info)
    TextView tv_detail_info;
    @BindView(R.id.tv_detail_author_intro_str)
    TextView tv_detail_author_intro_str;
    private MusicsBean musicsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        handleMaterialStatusBar();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        DouBanPersenter douBanPersenter = new DouBanPersenter(this);
        douBanPersenter.getMusic01Detail(this, DouBanApi.class, id);

        detailToolbar.setBackgroundColor(Color.BLACK);

        ivBack.setOnClickListener(this);
        tvDetailWantLook.setOnClickListener(this);
        tvDetailLookDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_detail_want_look:
                intent.putExtra("name", musicsBean.getTitle());
                intent.putExtra("alt", musicsBean.getAlt());
                startActivity(intent);
                break;
            case R.id.tv_detail_look_details:
                intent.putExtra("name", musicsBean.getTitle());
                intent.putExtra("alt", musicsBean.getAlt());
                startActivity(intent);
                break;
        }
    }


    private void showUI(MusicsBean musicsBean) {
        tvToolbarTitle.setText(musicsBean.getTitle());
        Glide.with(this).load(musicsBean.getImage()).into(ivDetailHead);
        tvDetailName.setText(musicsBean.getTitle());
        if (musicsBean.getRating().getAverage() != null) {
            tvDetailScore.setText("评分:" + musicsBean.getRating().getAverage());
        } else {
            tvDetailScore.setText("暂无评分");
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < musicsBean.getAuthor().size(); i++) {
            builder.append(musicsBean.getAuthor().get(i).getName() + " ");
        }
        tvDetailAuthor.setText("艺术家:" + builder);
//        tv_detail_info.setText("出版时间:" + musicsBean.getPubdate() + "\n"
//                + "出版社:" + musicsBean.getPublisher() + "\n"
//                + "页码:" + musicsBean.getPages() + "\n"
//                + "价格:" + musicsBean.getPrice() + "\n");
        tv_detail_info.setText("专辑时间:" + musicsBean.getAttrs().getPubdate().get(0)+"\n"
        +"评论:"+musicsBean.getRating().getNumRaters());
        tvDetailAuthorIntro.setVisibility(View.GONE);
        tv_detail_author_intro_str.setVisibility(View.GONE);
        tv_detail_author_intro_str.setVisibility(View.GONE);
        StringBuilder builderIntro = new StringBuilder();
        for (int i = 0; i < musicsBean.getTags().size(); i++) {
            builderIntro.append(musicsBean.getTags().get(i).getName()+"/");
        }
        builderIntro.deleteCharAt(builderIntro.length() - 1);
        tvDetailBookIntro.setText(builderIntro);
        tvDetailBookInfo.setText(musicsBean.getAttrs().getTracks().get(0));
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

        window.setStatusBarColor(getResources().getColor(R.color.black01));

    }

    @Override
    public void onMusicDetailSuccess(MusicsBean musicsBean) {
        this.musicsBean =musicsBean;
        showUI(musicsBean);
    }

    @Override
    public void onMusicDetailFaild() {
        ShowUtil.toast(this,"网络错误");
    }
}
