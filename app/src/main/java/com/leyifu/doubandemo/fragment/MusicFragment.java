package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.MusicAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


    List<String> titles = new ArrayList<>();
    @BindView(R.id.music_tab_layout)
    TabLayout musicTabLayout;
    @BindView(R.id.music_view_pager)
    ViewPager musicViewPager;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        titles.add("经典");
        titles.add("流行");
        titles.add("韩系");
        titles.add("欧美");

        musicTabLayout.addTab(musicTabLayout.newTab().setText(titles.get(0)));
        musicTabLayout.addTab(musicTabLayout.newTab().setText(titles.get(1)));
        musicTabLayout.addTab(musicTabLayout.newTab().setText(titles.get(2)));
        musicTabLayout.addTab(musicTabLayout.newTab().setText(titles.get(3)));
        musicViewPager.setAdapter(new MusicAdapter(getActivity().getSupportFragmentManager(),titles));
        musicTabLayout.setupWithViewPager(musicViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
