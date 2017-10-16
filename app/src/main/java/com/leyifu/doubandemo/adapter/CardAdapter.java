package com.leyifu.doubandemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.BaseCardAdapter;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.bean.hotmovie.SubjectsBean;

import java.util.List;

/**
 * Created by hahaha on 2017/10/11 0011.
 */

public class CardAdapter extends BaseCardAdapter {

    private List<SubjectsBean> datas;
    private Context context;

    public CardAdapter(List<SubjectsBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public int getCardLayoutId() {
        return R.layout.item;
    }

    @Override
    public void onBindData(int position, View cardview) {
        if (datas == null || datas.size() == 0) {
            return;
        }
        ImageView imageView = (ImageView) cardview.findViewById(R.id.iv_meizi);
        String url = datas.get(position).getImages().getLarge();
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 如果可见的卡片数是3，则可以不用实现这个方法
     *
     * @return
     */
    @Override
    public int getVisibleCardCount() {
        return super.getVisibleCardCount();
    }
}
