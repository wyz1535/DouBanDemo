package com.leyifu.doubandemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.bean.hotmoviedetail.MoviePeopleBean;

import java.util.List;

/**
 * Created by xingxing on 2017/8/31.
 */

public class CastsDetailAdapter extends BaseAdapter {

    private List<MoviePeopleBean> moviePeopleList;

    public CastsDetailAdapter(List<MoviePeopleBean> moviePeopleList) {
        this.moviePeopleList = moviePeopleList;
    }

    @Override
    public int getCount() {
        return moviePeopleList == null ? 0 : (moviePeopleList.size());
    }

    @Override
    public Object getItem(int i) {
        return moviePeopleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = View.inflate(viewGroup.getContext(), R.layout.item_movie_detail, null);
        }
        ViewHolder viewHolder = ViewHolder.getViewHolder(convertView);
        if (moviePeopleList.get(i).getType() == 1){
            Glide.with(viewGroup.getContext()).load(moviePeopleList.get(i).getAvatars().getLarge()).into(ViewHolder.iv_item_poster);
            viewHolder.tv_item_casts_name.setText(moviePeopleList.get(i).getName());
            viewHolder.tv_item_casts_type.setText("[导演]");
        } else{
            Glide.with(viewGroup.getContext()).load(moviePeopleList.get(i).getAvatars().getLarge()).into(ViewHolder.iv_item_poster);
            viewHolder.tv_item_casts_name.setText(moviePeopleList.get(i).getName());
            viewHolder.tv_item_casts_type.setText("[演员]");
        }
        return convertView;
    }

    private static class ViewHolder {

        private static ImageView iv_item_poster;
        private static TextView tv_item_casts_name;
        private static TextView tv_item_casts_type;

        public static ViewHolder getViewHolder(View convertView) {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder();
                viewHolder.iv_item_poster = ((ImageView) convertView.findViewById(R.id.iv_item_poster));
                viewHolder.tv_item_casts_name = ((TextView) convertView.findViewById(R.id.tv_item_casts_name));
                viewHolder.tv_item_casts_type = ((TextView) convertView.findViewById(R.id.tv_item_casts_type));
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }
    }
}
