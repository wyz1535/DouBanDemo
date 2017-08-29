package com.leyifu.doubandemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xingxing on 2017/8/29.
 */
public class MovieAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;
    private  List<String> titles;

    public MovieAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
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
        container.removeView(((View) object));

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
