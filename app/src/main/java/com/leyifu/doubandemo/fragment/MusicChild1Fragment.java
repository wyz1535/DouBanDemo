package com.leyifu.doubandemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leyifu.doubandemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicChild1Fragment extends Fragment {


    @BindView(R.id.textview)
    TextView textview;
    Unbinder unbinder;
    private String title;
    private int position;

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
        View view = inflater.inflate(R.layout.fragment_music_child1, container, false);
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

        textview.setText(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
