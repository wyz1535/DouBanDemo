package com.leyifu.doubandemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.google.gson.Gson;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.CardAdapter;
import com.leyifu.doubandemo.bean.hotmovie.HotMovieBean;
import com.leyifu.doubandemo.bean.hotmovie.SubjectsBean;
import com.leyifu.doubandemo.bean.top250.Top250Bean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.interf.IgetTop250View;
import com.leyifu.doubandemo.presenter.DouBanPersenter;
import com.leyifu.doubandemo.util.HttpUtil;
import com.leyifu.doubandemo.util.ShowUtil;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by hahaha on 2017/10/11 0011.
 */

public class PictureFragment extends Fragment implements IgetTop250View {

    private View view;
    private SwipeFlingAdapterView swipe_fling;
    private String TAG = "PictureFragment";
    private CardAdapter adapter;
    private DouBanPersenter douBanPersenter;
    private static final int SUCCEES = 0;
    private static final int DEFEATED = 1;
    String url = Constants.URL + "v2/movie/in_theaters";

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCEES:
                    List<SubjectsBean> subjects = (List<SubjectsBean>) msg.obj;
//                    hotMovieAdapter = new HotMovieAdapter(getActivity(), subjects,widthPixels,heightPixels);
                    adapter = new CardAdapter(subjects, view.getContext());
                    swipe_fling.setAdapter((Adapter) adapter);
                    break;
                case DEFEATED:
                    ShowUtil.toast(getActivity(),"数据请求失败");
                    break;
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_picture, container, false);
        init();
        return view;
    }

    private void init() {

        swipe_fling = ((SwipeFlingAdapterView) view.findViewById(R.id.swipe_fling));

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

//        douBanPersenter = new DouBanPersenter(getActivity());
//        douBanPersenter.getTop250(this, DouBanApi.class, 0, 10, false);
    }

    @Override
    public void getTop250Success(Top250Bean top250Bean, boolean isLoadMore) {
//        adapter = new CardAdapter(top250Bean.getSubjects(), view.getContext());
//        swipe_fling.setAdapter((Adapter) adapter);

//        swipe_fling.setFlingListener(flingListener);
//
//        swipe_fling.setOnItemClickListener(itemClick);

        Log.e(TAG, "getTop250Success: ");
    }

    @Override
    public void getTopFaild() {
        Log.e(TAG, "getTopFaild: ");
    }

    SwipeFlingAdapterView.OnItemClickListener itemClick = new SwipeFlingAdapterView.OnItemClickListener() {
        @Override
        public void onItemClicked(int i, Object o) {
            Log.e(TAG, "onItemClicked: ");
        }
    };

    SwipeFlingAdapterView.onFlingListener flingListener = new SwipeFlingAdapterView.onFlingListener() {
        @Override
        public void removeFirstObjectInAdapter() {
            Log.e(TAG, "removeFirstObjectInAdapter: ");
//            list.add(list.size(),list.get(0));
//            list.remove(0);
//            adapter.notifyDataSetChanged();
        }

        @Override
        public void onLeftCardExit(Object o) {
            Log.e(TAG, "onLeftCardExit: ");
        }

        @Override
        public void onRightCardExit(Object o) {
            Log.e(TAG, "onRightCardExit: ");
        }

        @Override
        public void onAdapterAboutToEmpty(int i) {
            Log.e(TAG, "onAdapterAboutToEmpty: ");
//            list.add("XML ".concat(String.valueOf(i)));
//            adapter.notifyDataSetChanged();
//            i++;
        }

        @Override
        public void onScroll(float v) {
            Log.e(TAG, "onScroll: ");
        }
    };


}
