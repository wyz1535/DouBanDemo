package com.leyifu.doubandemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.acticity.MovieDetialActivity;
import com.leyifu.doubandemo.bean.top250.SubjectsBean;

import java.util.List;

/**
 * Created by xingxing on 2017/9/4.
 */

public class Top250RecyclerAdapter extends RecyclerView.Adapter<Top250RecyclerAdapter.ViewHolder> {

    public static final int TYPE_FOOTER = -2;
    public static final int TYPE_TIEM = -1;
    public static final int LOAD_TO_PULL = 1;
    public static final int LOAD_MORE = 3;
    public static final int LOAD_NONE = 0;
    private int state = 1;
    private List<SubjectsBean> subjects;
    private Context context;
    private int number = 01;

    public Top250RecyclerAdapter(Context context, List<SubjectsBean> subjects) {
        this.subjects = subjects;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return position;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_footer, null);
            return new FooterViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_top250, null);
            final ViewHolder viewHolder = new ViewHolder(view);
            viewHolder.ll_item_top250.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = viewHolder.getAdapterPosition();
                    Intent intent = new Intent(context, MovieDetialActivity.class);
                    intent.putExtra("id", subjects.get(position).getId());
                    context.startActivity(intent);
                }
            });
            return viewHolder;
        }
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        } else if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = holder;
            viewHolder.bindItem(subjects, position);
        }
    }

    @Override
    public int getItemCount() {

        return subjects == null ? 0 : subjects.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv_item_picture;
        private final TextView tv_item_name;
        private final TextView tv_item_origin_name;
        private final TextView tv_item_score;
        private final TextView tv_item_number;
        private final LinearLayout ll_item_top250;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_item_picture = ((ImageView) itemView.findViewById(R.id.iv_item_picture));
            ll_item_top250 = ((LinearLayout) itemView.findViewById(R.id.ll_item_top250));
            tv_item_name = ((TextView) itemView.findViewById(R.id.tv_item_name));
            tv_item_origin_name = ((TextView) itemView.findViewById(R.id.tv_item_origin_name));
            tv_item_score = ((TextView) itemView.findViewById(R.id.tv_item_score));
            tv_item_number = ((TextView) itemView.findViewById(R.id.tv_item_number));
        }

        public void bindItem(List<SubjectsBean> subjects, int position) {
            Glide.with(context).load(subjects.get(position).getImages().getLarge()).into(iv_item_picture);
            tv_item_name.setText(subjects.get(position).getTitle());
            tv_item_origin_name.setText(subjects.get(position).getOriginal_title());
            tv_item_score.setText("评分:" + subjects.get(position).getRating().getAverage());
            if (position < 9) {
                tv_item_number.setText("0" + (position + 1));
            } else {
                tv_item_number.setText("" + (position + 1));
            }
        }
    }

    class FooterViewHolder extends ViewHolder {
        View view;
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
                case LOAD_MORE:
                    progress_bar.setVisibility(View.VISIBLE);
                    tv_footer_load.setText("加载更多...");
                    view.setVisibility(View.VISIBLE);
                    break;
                case LOAD_TO_PULL:
                    progress_bar.setVisibility(View.GONE);
                    tv_footer_load.setText("上拉加载更多...");
                    view.setVisibility(View.VISIBLE);
                    break;
                case LOAD_NONE:
                    progress_bar.setVisibility(View.GONE);
                    tv_footer_load.setText("没有更多...");
//                    view.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    public void updataState(int state) {
        this.state = state;
        notifyDataSetChanged();
    }
}
