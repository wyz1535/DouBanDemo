package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.Top250RecyclerAdapter;
import com.leyifu.doubandemo.bean.top250.SubjectsBean;
import com.leyifu.doubandemo.bean.top250.Top250Bean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetTop250View;
import com.leyifu.doubandemo.presenter.DouBanPersenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Top250Fragment extends Fragment implements IgetTop250View {

    private static final int SUCCEED = 0;
    private static final int FAILD = 1;
    private static final String TAG = "Top250Fragment";
    private RecyclerView lv_top250;
    private int pageCount;
    private int PAGE_SIZE = 10;
    private static final String URL = Constants.URL + "v2/movie/top250";
    private LinearLayoutManager linearLayoutManager;
    private Top250RecyclerAdapter adapter;

    private List<SubjectsBean> subjects;
    private Top250Bean mTop250Bean;
    private DouBanPersenter douBanPersenter;
    private SwipeRefreshLayout top250_swipe;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top250, container, false);
        initView(view);
        initData();
        init();
        return view;
    }

    private void initView(View view) {
        lv_top250 = ((RecyclerView) view.findViewById(R.id.lv_top250));
        top250_swipe = ((SwipeRefreshLayout) view.findViewById(R.id.top250_swipe));
        floatingActionButton = ((FloatingActionButton) view.findViewById(R.id.floatingActionButton));
    }

    private void init() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        lv_top250.setLayoutManager(linearLayoutManager);
        lv_top250.addOnScrollListener(onscrollListener);
        top250_swipe.setColorSchemeResources(R.color.colorAccent);
        top250_swipe.setOnRefreshListener(onrefreshListener);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                firstVisibleItemPosition = 0;
                lv_top250.smoothScrollToPosition(0);
            }
        });
    }

    RecyclerView.OnScrollListener onscrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItemPosition;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                final int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                if (firstVisibleItemPosition == 0 || firstVisibleItemPosition == -1) {
                    floatingActionButton.setVisibility(View.INVISIBLE);
                } else {
                    floatingActionButton.setVisibility(View.VISIBLE);
                }

                if (linearLayoutManager.getItemCount() == 1) {
                    if (adapter != null) {
                        adapter.updataState(adapter.LOAD_NONE);
                        floatingActionButton.setVisibility(View.INVISIBLE);
                    }
                    return;
                }
                if (lastVisibleItemPosition + 1 == linearLayoutManager.getItemCount()) {
                    if (adapter != null) {
                        adapter.updataState(adapter.LOAD_TO_PULL);
                        adapter.updataState(adapter.LOAD_MORE);
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 2017/9/5  获取数据
                        pageCount++;
                        douBanPersenter.getTop250(Top250Fragment.this, DouBanApi.class, pageCount * PAGE_SIZE, PAGE_SIZE, true);
                    }
                }, 1000);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        }
    };

    SwipeRefreshLayout.OnRefreshListener onrefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            douBanPersenter.getTop250(Top250Fragment.this, DouBanApi.class, pageCount * PAGE_SIZE, PAGE_SIZE, false);
            top250_swipe.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (top250_swipe != null) {
                        top250_swipe.setRefreshing(false);
                    }
                }
            }, 1000);
        }
    };


    private void initData() {
        douBanPersenter = new DouBanPersenter(getActivity());
        douBanPersenter.getTop250(this, DouBanApi.class, pageCount * PAGE_SIZE, PAGE_SIZE, false);
    }

    @Override
    public void getTop250Success(Top250Bean top250Bean, boolean isLoadMore) {
        if (isLoadMore) {
            mTop250Bean.getSubjects().addAll(top250Bean.getSubjects());
            adapter.notifyDataSetChanged();
        } else {
            mTop250Bean = top250Bean;
            adapter = new Top250RecyclerAdapter(getActivity(), mTop250Bean.getSubjects());
            lv_top250.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getTopFaild() {

    }


}
