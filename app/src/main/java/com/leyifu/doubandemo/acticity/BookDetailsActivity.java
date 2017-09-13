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
import com.leyifu.doubandemo.bean.book.BooksBean;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetBookDetail;
import com.leyifu.doubandemo.presenter.DouBanPersenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends BaseActivity implements View.OnClickListener, IgetBookDetail {

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
    private BooksBean booksBean;

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
        douBanPersenter.getBooksDetail(this, DouBanApi.class, id);

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
                intent.putExtra("name", booksBean.getTitle());
                intent.putExtra("alt", booksBean.getAlt());
                startActivity(intent);
                break;
            case R.id.tv_detail_look_details:
                intent.putExtra("name", booksBean.getTitle());
                intent.putExtra("alt", booksBean.getAlt());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBookDetailSuccess(BooksBean booksBean) {
        if (booksBean != null) {
            this.booksBean = booksBean;
            showUI(booksBean);
        }
    }

    @Override
    public void onBookDetailFaild() {

    }

    private void showUI(BooksBean booksBean) {
        tvToolbarTitle.setText(booksBean.getTitle());
        Glide.with(this).load(booksBean.getImages().getLarge()).into(ivDetailHead);
        tvDetailName.setText(booksBean.getTitle());
        if (booksBean.getRating().getAverage() != null) {
            tvDetailScore.setText("评分:" + booksBean.getRating().getAverage());
        } else {
            tvDetailScore.setText("暂无评分");
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < booksBean.getAuthor().size(); i++) {
            builder.append(booksBean.getAuthor().get(i) + " ");
        }
        tvDetailAuthor.setText("作者:" + builder);
        tv_detail_info.setText("出版时间:" + booksBean.getPubdate() + "\n"
                + "出版社:" + booksBean.getPublisher() + "\n"
                + "页码:" + booksBean.getPages() + "\n"
                + "价格:" + booksBean.getPrice() + "\n");
        tvDetailAuthorIntro.setText(booksBean.getAuthor_intro());
        tvDetailBookIntro.setText(booksBean.getSummary());
        tvDetailBookInfo.setText(booksBean.getCatalog());
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

}
