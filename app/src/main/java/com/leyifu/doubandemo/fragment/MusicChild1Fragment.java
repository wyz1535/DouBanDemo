package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.MusicRecyclerAdapter;
import com.leyifu.doubandemo.bean.music.MusicBean;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetMusicView;
import com.leyifu.doubandemo.presenter.DouBanPersenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicChild1Fragment extends Fragment implements IgetMusicView {

    Unbinder unbinder;
    @BindView(R.id.friends_recycler_view)
    RecyclerView friendsRecyclerView;
    @BindView(R.id.friends_swipe)
    SwipeRefreshLayout friendsSwipe;
    private String title;
    private int position;
    private int pageCount;
    private int pageSize=10;
    private MusicRecyclerAdapter adapter;
    private MusicBean mMusicBean;
    private DouBanPersenter douBanPersenter;
    private LinearLayoutManager linearLayoutManager;

    public static MusicChild1Fragment newInstance(int position, String title) {
        MusicChild1Fragment fragment = new MusicChild1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_child, container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString("title");
            position = arguments.getInt("position");
        }

        linearLayoutManager = new LinearLayoutManager(getActivity());
        friendsRecyclerView.setLayoutManager(linearLayoutManager);
        douBanPersenter = new DouBanPersenter(getActivity());
        douBanPersenter.getMusic(this, DouBanApi.class,title,pageCount,pageSize,false);
        friendsRecyclerView.addOnScrollListener(onScrollChange);
    }
        RecyclerView.OnScrollListener onScrollChange = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition == 1) {
                        if (adapter != null) {
                            adapter.updataState(adapter.LOAD_NONE);
                            return;
                        }

                        if (lastVisibleItemPosition + 1 == linearLayoutManager.getItemCount()) {
                            if (adapter != null) {
                                adapter.updataState(adapter.LOAD_TO_PULL);
                                adapter.updataState(adapter.LOAD_MORE);
                            }

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    pageCount++;
                                    douBanPersenter.getMusic(MusicChild1Fragment.this, DouBanApi.class,title,pageCount,pageSize,true);
                                }
                            }, 1000);
                        }
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        };


    @Override
    public void onMusicSuccess(MusicBean musicBean, boolean isLoadMore) {
        if (isLoadMore) {
            mMusicBean.getMusics().addAll(musicBean.getMusics());
            adapter.notifyDataSetChanged();
        } else {
            this.mMusicBean =musicBean;
            adapter = new MusicRecyclerAdapter(getActivity(),mMusicBean.getMusics());
            friendsRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onFaild() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
