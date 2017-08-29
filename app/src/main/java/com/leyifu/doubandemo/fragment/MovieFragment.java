package com.leyifu.doubandemo.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;


public class MovieFragment extends Fragment {

    private RelativeLayout rl_hot_movie, rl_top250;
    private ViewPager view_pager_movie;
    private TabLayout tab_layout;

    private List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    public MovieFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        initView(view);
        init(view);
        return view;
    }

    private void initView(View view) {
        tab_layout = ((TabLayout) view.findViewById(R.id.tab_layout));
        view_pager_movie = ((ViewPager) view.findViewById(R.id.view_pager_movie));
    }

    private void init(View view) {
        fragments.add(new HotMovieFragment());
        fragments.add(new Top250Fragment());

        titles.add("热映榜");
        titles.add("TOP250");

        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();

        tab_layout.setTag(tab_layout.newTab().setText(titles.get(0)));
        tab_layout.setTag(tab_layout.newTab().setText(titles.get(1)));
        view_pager_movie.setAdapter(new MovieAdapter(supportFragmentManager, fragments, titles));
        view_pager_movie.setOffscreenPageLimit(3);
        tab_layout.setupWithViewPager(view_pager_movie);
    }
}
