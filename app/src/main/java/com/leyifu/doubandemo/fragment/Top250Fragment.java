package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.Top250RecyclerAdapter;
import com.leyifu.doubandemo.bean.top250.SubjectsBean;
import com.leyifu.doubandemo.bean.top250.Top250Bean;
import com.leyifu.doubandemo.constant.Constants;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.util.ApiUtil;
import com.leyifu.doubandemo.util.ShowUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class Top250Fragment extends Fragment {

    private static final int SUCCEED = 0;
    private static final int FAILD = 1;
    private static final String TAG = "Top250Fragment";
    private RecyclerView lv_top250;
    private int pageCount ;
    private int PAGE_SIZE = 10;
    List<SubjectsBean> subjectsSize = new ArrayList<>();
    private static final String URL = Constants.URL + "v2/movie/top250";
    private LinearLayoutManager linearLayoutManager;
    private Top250RecyclerAdapter adapter;

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCEED:
                    Top250Bean top250Bean = (Top250Bean) msg.obj;
                    if (top250Bean != null) {
//                        lv_top250.setAdapter(new Top250Adapter(top250Bean.getSubjects()));
                        Log.e(TAG, "top250Bean: " + top250Bean);
                        subjects = top250Bean.getSubjects();
                        for (int i = 0; i < PAGE_SIZE; i++) {
                            SubjectsBean subjectsBean = subjects.get(i);
                            subjectsSize.add(subjectsBean);
                        }
                        adapter = new Top250RecyclerAdapter(getActivity(), subjectsSize);
                        lv_top250.setAdapter(adapter);
                    }
                    break;
                case FAILD:
                    ShowUtil.toast(getContext(), "数据请求失败");
                    break;
            }
        }
    };
    private List<SubjectsBean> subjects;

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
    }

    private void init() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        lv_top250.setLayoutManager(linearLayoutManager);
        lv_top250.addOnScrollListener(onscrollListener);
    }

    RecyclerView.OnScrollListener onscrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItemPosition;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (linearLayoutManager.getItemCount() == 1) {
                    if (adapter != null) {
                        adapter.updataState(adapter.LOAD_NONE);
                    }
                    return;
                }
                if (lastVisibleItemPosition + 1 == linearLayoutManager.getItemCount()) {
                    adapter.updataState(adapter.LOAD_TO_PULL);
                    adapter.updataState(adapter.LOAD_MORE);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: 2017/9/5  获取数据
                        pageCount++;
//

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


    private void initData() {
//        HttpUtil.sendHttpRequest(URL, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                handler.sendEmptyMessage(FAILD);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                if (result != null) {
//                    Top250Bean top250Bean = new Gson().fromJson(result, Top250Bean.class);
//                    Message message = handler.obtainMessage();
//                    message.what = SUCCEED;
//                    message.obj = top250Bean;
//                    handler.sendMessage(message);
//                }
//            }
//        });

        Observable<Top250Bean> observable = ApiUtil.getRetrofir().create(DouBanApi.class).getTop250Movie(pageCount, PAGE_SIZE);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Top250Bean>() {
                    @Override
                    public void call(Top250Bean top250Bean) {
                        Log.e(TAG, "call: " + top250Bean);
                        List<SubjectsBean> subjects = top250Bean.getSubjects();
                        adapter = new Top250RecyclerAdapter(getActivity(), subjects);
                        lv_top250.setAdapter(adapter);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ShowUtil.toast(getActivity(), "网络错误");
                    }
                });
    }

}
