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
public class FriendsChildFragment extends Fragment {

    @BindView(R.id.textview)
    TextView textview;
    Unbinder unbinder;
    private static String title;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_child, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int position = arguments.getInt("position");
             title = arguments.getString("title");
            textview.setText(title);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
