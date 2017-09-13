package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.BookAdapter;
import com.leyifu.doubandemo.bean.book.BookBean;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetBookView;
import com.leyifu.doubandemo.presenter.DouBanPersenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsChildFragment extends Fragment implements IgetBookView {

    private static final String TAG = FriendsChildFragment.class.getSimpleName();

    Unbinder unbinder;
    private static String title;
    @BindView(R.id.friends_recycler_view)
    RecyclerView friendsRecyclerView;
    @BindView(R.id.friends_swipe)
    SwipeRefreshLayout friendsSwipe;
    private int pageCount;
    private int PAGE_SIZE = 10;
    private BookAdapter adapter;
    private GridLayoutManager manager;
    private DouBanPersenter douBanPersenter;
    private BookBean mBookBean;
    private int widthPixels;
    private int heightPixels;


    public static FriendsChildFragment newInstance(int positon, String title) {
        FriendsChildFragment fragment = new FriendsChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("position", positon);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends_child, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int position = arguments.getInt("position");
            title = arguments.getString("title");
        }
        initView();
        init();
        return view;
    }

    private void initView() {

    }

    private void init() {

        widthPixels = getResources().getDisplayMetrics().widthPixels;
        heightPixels = getResources().getDisplayMetrics().heightPixels;
        friendsSwipe.setColorSchemeResources(R.color.colorAccent);
        friendsSwipe.setOnRefreshListener(onRefreshListener);

        douBanPersenter = new DouBanPersenter(getActivity());
        douBanPersenter.getFriends01(this, DouBanApi.class, title, pageCount, PAGE_SIZE, false);

        manager = new GridLayoutManager(getActivity(), 3);
        friendsRecyclerView.setLayoutManager(manager);
        friendsRecyclerView.addOnScrollListener(onScrollListener);
    }

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            douBanPersenter.getFriends01(FriendsChildFragment.this, DouBanApi.class, title, pageCount, PAGE_SIZE, false);
            friendsSwipe.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (friendsSwipe != null) {
                        friendsSwipe.setRefreshing(false);
                    }
                }
            }, 2000);
        }
    };


    RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {


                int lastVisibleItemPosition = manager.findLastVisibleItemPosition();
                if (manager.getItemCount() == 1) {
                    if (adapter != null) {
                        adapter.updataState(adapter.MORE_NONE);
                        return;
                    }
                }
                if (lastVisibleItemPosition + 1 == manager.getItemCount()) {
                    if (adapter != null) {
                        adapter.updataState(adapter.LOAD_TO_PULL);
                        adapter.updataState(adapter.LOADING_MORE);
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageCount++;
                        douBanPersenter.getFriends01(FriendsChildFragment.this, DouBanApi.class, title, pageCount, PAGE_SIZE, true);
                    }
                }, 2000);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onBookSuccess(BookBean bookBean, boolean isLoadMore) {
//        Log.e(TAG, "onBookSuccess: " + bookBean);
        if (isLoadMore) {
            mBookBean.getBooks().addAll(bookBean.getBooks());
            adapter.notifyDataSetChanged();
        } else {
            this.mBookBean = bookBean;
            adapter = new BookAdapter(getActivity(), mBookBean.getBooks(), widthPixels, heightPixels);
            friendsRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onBookFailed() {

    }
}
