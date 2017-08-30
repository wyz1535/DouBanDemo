package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.HotMovieAdapter;
import com.leyifu.doubandemo.bean.hotmovie.HotMovieBean;
import com.leyifu.doubandemo.bean.hotmovie.SubjectsBean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.util.HttpUtil;
import com.leyifu.doubandemo.util.ShowUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotMovieFragment extends Fragment {

    private static final int SUCCEES = 0;
    private static final int DEFEATED = 1;
    private String TAG = "HotMovieFragment";
    String url = Constants.URL + "v2/movie/in_theaters";
    private SwipeRefreshLayout hot_movie_swipe;
    private RecyclerView hot_movie_recycle_view;
    private HotMovieAdapter hotMovieAdapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCEES:
                    List<SubjectsBean> subjects = (List<SubjectsBean>) msg.obj;
                    hotMovieAdapter = new HotMovieAdapter(getActivity(), subjects,widthPixels,heightPixels);
                    hot_movie_recycle_view.setAdapter(hotMovieAdapter);
                    break;
                case DEFEATED:
                    ShowUtil.showToast(getActivity(),"数据请求失败");
                    break;
            }

        }
    };
    private int widthPixels;
    private int heightPixels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_movie, container, false);
        initView(view);
        initData();
        init(view);

        return view;
    }

    private void initView(View view) {
        hot_movie_swipe = ((SwipeRefreshLayout) view.findViewById(R.id.hot_movie_swipe));
        hot_movie_recycle_view = ((RecyclerView) view.findViewById(R.id.hot_movie_recycle_view));
    }

    private void init(View view) {



        hot_movie_swipe.setColorSchemeResources(R.color.colorAccent,R.color.black,R.color.colorPrimary);
        widthPixels = getResources().getDisplayMetrics().widthPixels;
        heightPixels = getResources().getDisplayMetrics().heightPixels;
        Log.e(TAG, "widthPixels="+ widthPixels +"&heightPixels="+ heightPixels);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        hot_movie_recycle_view.setLayoutManager(gridLayoutManager);

        hot_movie_swipe.setOnRefreshListener(refreshListener);
    }

        SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                hot_movie_swipe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (hot_movie_swipe != null) {
                            hot_movie_swipe.setRefreshing(false);
                        }
                    }
                }, 3000);
                initData();
            }
        };

    private void initData() {
        HttpUtil.sendHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(DEFEATED);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                HotMovieBean hotMovieBean = new Gson().fromJson(body, HotMovieBean.class);
                if (hotMovieBean != null) {
                    List<SubjectsBean> subjects = hotMovieBean.getSubjects();
                    Message message = handler.obtainMessage();
                    message.what = SUCCEES;
                    message.obj = subjects;
                    handler.sendMessage(message);
                }
            }
        });
    }



}
