package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.FriendsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    @BindView(R.id.friends_tab_layout)
    TabLayout friendsTabLayout;
    @BindView(R.id.friends_view_pager)
    ViewPager friendsViewPager;

    List<String> titles = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        titles.add("综合");
        titles.add("文学");
        titles.add("流行");
        titles.add("文化");
        titles.add("生活");
        friendsTabLayout.addTab(friendsTabLayout.newTab().setText(titles.get(0)),true);
        friendsTabLayout.addTab(friendsTabLayout.newTab().setText(titles.get(1)));
        friendsTabLayout.addTab(friendsTabLayout.newTab().setText(titles.get(2)));
        friendsTabLayout.addTab(friendsTabLayout.newTab().setText(titles.get(3)));
        friendsTabLayout.addTab(friendsTabLayout.newTab().setText(titles.get(4)));

        friendsTabLayout.setupWithViewPager(friendsViewPager);
        friendsViewPager.setOffscreenPageLimit(5);
        friendsViewPager.setAdapter(new FriendsAdapter(getActivity().getSupportFragmentManager(),titles));
        friendsViewPager.addOnPageChangeListener(onPageChange);
    }

        ViewPager.OnPageChangeListener onPageChange = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

}
