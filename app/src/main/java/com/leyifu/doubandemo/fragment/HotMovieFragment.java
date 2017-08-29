package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.HotMovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotMovieFragment extends Fragment {


    private SwipeRefreshLayout hot_movie_swipe;
    private RecyclerView hot_movie_recycle_view;
    private HotMovieAdapter hotMovieAdapter;

    public HotMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_movie, container, false);
        initView(view);
        init();
        return view;
    }

    private void initView(View view) {
        hot_movie_swipe = ((SwipeRefreshLayout) view.findViewById(R.id.hot_movie_swipe));
        hot_movie_recycle_view = ((RecyclerView) view.findViewById(R.id.hot_movie_recycle_view));
    }

    private void init() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        hot_movie_recycle_view.setLayoutManager(gridLayoutManager);
        hotMovieAdapter = new HotMovieAdapter();
        hot_movie_recycle_view.setAdapter(hotMovieAdapter);
    }

}
