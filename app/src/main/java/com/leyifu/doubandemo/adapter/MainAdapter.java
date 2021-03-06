package com.leyifu.doubandemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.leyifu.doubandemo.util.ShowUtil;

import java.util.List;

/**
 * Created by hahaha on 2017/8/29 0029.
 */

public class MainAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;

    public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        ShowUtil.e("destroyItem=",position+"");
//        container.removeView(((View) object));
    }
}
