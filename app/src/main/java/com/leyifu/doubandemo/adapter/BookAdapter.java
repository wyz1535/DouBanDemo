package com.leyifu.doubandemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.bean.book.BooksBean;

import java.util.List;

/**
 * Created by xingxing on 2017/9/12.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private static final int FOOT_LAYOUT = -1;
    private int state;
    public static final int MORE_NONE = 0;
    public static final int LOAD_TO_PULL = 1;
    public static final int LOADING_MORE = 2;
    private Context context;
    private List<BooksBean> books;
    private int widthPixels;
    private int heightPixels;

    public BookAdapter(Context context, List<BooksBean> books, int widthPixels, int heightPixels) {
        this.context = context;
        this.books = books;
        this.widthPixels =widthPixels;
        this.heightPixels = heightPixels;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return FOOT_LAYOUT;
        } else {
            return position;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }

        if (viewType == FOOT_LAYOUT) {
            View view = View.inflate(context, R.layout.item_footer, null);
            return new FooterViewHolder(view);
        } else {
            View view = View.inflate(context, R.layout.item_recycler_hot, null);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        } else if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.bindItem(books, position);
        }
    }

    @Override
    public int getItemCount() {
        return books == null ? 0 : books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView iv_hot_movie;
        private final TextView tv_movie_name;
        private final TextView tv_score;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_hot_movie = ((ImageView) itemView.findViewById(R.id.iv_hot_movie));
            tv_movie_name = ((TextView) itemView.findViewById(R.id.tv_movie_name));
            tv_score = ((TextView) itemView.findViewById(R.id.tv_score));

        }

        public void bindItem(List<BooksBean> books, int position) {
            ViewGroup.LayoutParams layoutParams = iv_hot_movie.getLayoutParams();
            layoutParams.width =  (widthPixels - 120) / 3;
            layoutParams.height = (heightPixels - 400) / 3;
            iv_hot_movie.setLayoutParams(layoutParams);
            Log.e("widthPixels", "widthPixels: " + widthPixels + "&heightPixels=" + heightPixels);
            Glide.with(context).load(books.get(position).getImages().getLarge()).into(iv_hot_movie);
            tv_movie_name.setText(books.get(position).getTitle());
            tv_score.setText("评分:"+books.get(position).getRating().getAverage());
        }
    }

    private class FooterViewHolder extends ViewHolder {
        private View view;
        private final LinearLayout ll_footer;
        private final ProgressBar progress_bar;
        private final TextView tv_footer_load;

        public FooterViewHolder(View view) {
            super(view);
            this.view = view;
            ll_footer = ((LinearLayout) view.findViewById(R.id.ll_footer));
            progress_bar = ((ProgressBar) view.findViewById(R.id.progress_bar));
            tv_footer_load = ((TextView) view.findViewById(R.id.tv_footer_load));
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
            itemView.setLayoutParams(params);
        }

        public void bindItem() {
            switch (state) {
                case MORE_NONE:
                    tv_footer_load.setText("没有更多");
                    progress_bar.setVisibility(View.GONE);
                    break;
                case LOAD_TO_PULL:
                    tv_footer_load.setText("上拉加载更多");
                    progress_bar.setVisibility(View.GONE);
                    view.setVisibility(View.VISIBLE);
                    break;
                case LOADING_MORE:
                    tv_footer_load.setText("正在加载");
                    progress_bar.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    public void updataState(int state) {
        this.state = state;
        notifyDataSetChanged();
    }
}
