package com.leyifu.doubandemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.bean.top250.SubjectsBean;

import java.util.List;

/**
 * Created by xingxing on 2017/9/3.
 */

public class Top250Adapter extends BaseAdapter {

    private int number;
    private List<SubjectsBean> subjects;

    public Top250Adapter(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    @Override
    public int getCount() {
        return subjects == null ? 0 : subjects.size();
    }

    @Override
    public Object getItem(int i) {
        return subjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = View.inflate(viewGroup.getContext(), R.layout.item_top250, null);
        }
        ViewHolder viewHolder = ViewHolder.getViewHolder(convertView);
        viewHolder.tv_item_number.setText((number++)+"");
      //  Glide.with(viewGroup.getContext()).load(subjects.get(i).getImages().getLarge()).into(viewHolder.iv_item_picture);
        viewHolder.tv_item_name.setText(subjects.get(i).getTitle());
        viewHolder.tv_item_origin_name.setText(subjects.get(i).getOriginal_title());
        viewHolder.tv_item_score.setText("评分:" + subjects.get(i).getRating().getAverage());
        return convertView;
    }

    private static class ViewHolder {
        private static ImageView iv_item_picture;
        private static TextView tv_item_name;
        private static TextView tv_item_origin_name;
        private static TextView tv_item_score;
        private static TextView tv_item_number;

        public static ViewHolder getViewHolder(View convertView) {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder();
                tv_item_number = ((TextView) convertView.findViewById(R.id.tv_item_number));
                viewHolder.iv_item_picture = ((ImageView) convertView.findViewById(R.id.iv_item_picture));
                viewHolder.tv_item_name = ((TextView) convertView.findViewById(R.id.tv_item_name));
                viewHolder.tv_item_origin_name = ((TextView) convertView.findViewById(R.id.tv_item_origin_name));
                viewHolder.tv_item_score = ((TextView) convertView.findViewById(R.id.tv_item_score));
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }
    }
}
