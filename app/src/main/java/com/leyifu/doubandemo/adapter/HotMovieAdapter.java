package com.leyifu.doubandemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.acticity.MovieDetialActivity;
import com.leyifu.doubandemo.bean.hotmovie.SubjectsBean;

import java.util.List;

/**
 * Created by xingxing on 2017/8/29.
 */
public class HotMovieAdapter extends RecyclerView.Adapter<HotMovieAdapter.ViewHolder> {

    private List<SubjectsBean> subjects;
    private Context context;
    private int widthPixels;
    private int heightPixels;

    public HotMovieAdapter(Context context, List<SubjectsBean> subjects, int widthPixels, int heightPixels) {
        this.subjects = subjects;
        this.context = context;
        this.widthPixels = widthPixels;
        this.heightPixels = heightPixels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_hot, null);
        final ViewHolder holder = new ViewHolder(view);
        holder.iv_hot_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, MovieDetialActivity.class);
                intent.putExtra("id", subjects.get(position).getId());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_movie_name.setText(subjects.get(position).getTitle());
        double average = subjects.get(position).getRating().getAverage();
        if (TextUtils.isEmpty(average + "")) {
            holder.tv_score.setText("暂无评分");
        } else {
            holder.tv_score.setText("评分:" + average);
        }
        ViewGroup.LayoutParams params = holder.iv_hot_movie.getLayoutParams();
        int mWidth = (widthPixels - 120) / 3;
        params.width = mWidth;
        params.height = (heightPixels - 400) / 3;
        holder.iv_hot_movie.setLayoutParams(params);
//        if (subjects.get(position).getImages() != null && TextUtils.isEmpty(subjects.get(position).getImages().getLarge())) {
            Glide.with(context).load(subjects.get(position).getImages().getLarge()).into(holder.iv_hot_movie);
//        }
    }

    @Override
    public int getItemCount() {
        return subjects == null ? 0 : subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_hot_movie;
        TextView tv_movie_name;
        TextView tv_score;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_hot_movie = ((ImageView) itemView.findViewById(R.id.iv_hot_movie));
            tv_movie_name = ((TextView) itemView.findViewById(R.id.tv_movie_name));
            tv_score = ((TextView) itemView.findViewById(R.id.tv_score));
        }
    }
}
