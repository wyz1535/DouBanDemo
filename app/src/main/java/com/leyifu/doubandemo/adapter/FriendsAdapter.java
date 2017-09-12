package com.leyifu.doubandemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.leyifu.doubandemo.fragment.FriendsChildFragment;

import java.util.List;

/**
 * Created by hahaha on 2017/9/12 0012.
 */

public class FriendsAdapter extends FragmentPagerAdapter {

    private List<String> titles;

    public FriendsAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return FriendsChildFragment.newInstance(position, titles.get(position));
    }

    @Override
    public int getCount() {
        return titles == null ? 0 : titles.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
