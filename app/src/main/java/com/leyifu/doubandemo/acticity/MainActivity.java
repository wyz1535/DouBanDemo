package com.leyifu.doubandemo.acticity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.leyifu.doubandemo.R;
import com.leyifu.doubandemo.adapter.MainAdapter;
import com.leyifu.doubandemo.fragment.FriendsFragment;
import com.leyifu.doubandemo.fragment.MovieFragment;
import com.leyifu.doubandemo.fragment.MusicFragment;
import com.leyifu.doubandemo.util.ShowUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Toolbar tool_bar;
    private RadioButton rb_movie;
    private RadioButton rb_friends;
    private RadioButton rb_music;
    private RadioGroup radio_group;
    private ImageView iv_drawable;
    private DrawerLayout drawer_layout;
    private NavigationView navigation_view;
    private int currentFragment;

    List<Fragment> fragments = new ArrayList<>();
    private ViewPager main_view_pager;
    private FragmentManager fragmentManager;
    private CircleImageView nav_head_viecle;
    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        init();

        initNavigation();

    }

    private void initView() {
        tool_bar = ((Toolbar) findViewById(R.id.tool_bar));
        drawer_layout = ((DrawerLayout) findViewById(R.id.drawer_layout));
        navigation_view = ((NavigationView) findViewById(R.id.navigation_view));
        iv_drawable = ((ImageView) findViewById(R.id.iv_drawable));
        radio_group = ((RadioGroup) findViewById(R.id.radio_group));
        rb_movie = ((RadioButton) findViewById(R.id.rb_movie));
        rb_friends = ((RadioButton) findViewById(R.id.rb_friends));
        rb_music = ((RadioButton) findViewById(R.id.rb_music));
        main_view_pager = ((ViewPager) findViewById(R.id.main_view_pager));
        tool_bar.setTitle("");
        setSupportActionBar(tool_bar);


    }

    private void init() {

        fragments.add(new MovieFragment());
        fragments.add(new FriendsFragment());
        fragments.add(new MusicFragment());

        fragmentManager = getSupportFragmentManager();

        radio_group.setOnCheckedChangeListener(checkChangeListener);

        main_view_pager.setAdapter(new MainAdapter(fragmentManager, fragments));
        main_view_pager.setOffscreenPageLimit(3);
        main_view_pager.addOnPageChangeListener(pageChangeListener);

        iv_drawable.setOnClickListener(this);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sharedPreferences.getString("name", null);
        String password = sharedPreferences.getString("password", null);
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
            ShowUtil.toast(this, "登陆成功");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        name = sharedPreferences.getString("name", null);
        password = sharedPreferences.getString("password", null);
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                radio_group.check(R.id.rb_movie);
            } else if (position == 1) {
                radio_group.check(R.id.rb_friends);
            } else if (position == 2) {
                radio_group.check(R.id.rb_music);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void initNavigation() {
        navigation_view.inflateMenu(R.menu.navigation_menu);
        View headerView = navigation_view.getHeaderView(0);
        nav_head_viecle = ((CircleImageView) headerView.findViewById(R.id.nav_head_circle));
        nav_head_viecle.setOnClickListener(this);
        navigation_view.setNavigationItemSelectedListener(navigationItemSelected);

        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };

        int[] colors = new int[]{getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.white)
        };
        ColorStateList csl = new ColorStateList(states, colors);

        navigation_view.setItemTextColor(csl);
        navigation_view.setItemIconTintList(csl);
//        navigation_view.itemTextColor = csl;
//        navigation_view.itemIconTintList = csl;
    }

    RadioGroup.OnCheckedChangeListener checkChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i) {
                case R.id.rb_movie:
                    currentFragment = 0;
                    break;
                case R.id.rb_friends:
                    currentFragment = 1;
                    break;
                case R.id.rb_music:
                    currentFragment = 2;
                    break;
            }
            main_view_pager.setCurrentItem(currentFragment, false);
        }
    };

    NavigationView.OnNavigationItemSelectedListener navigationItemSelected = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {
                case R.id.nav_home:

                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this, LandAndRegistActivity.class));
                    }
                    break;
                case R.id.nav_suggest:
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                        startActivity(new Intent(MainActivity.this, SuggestActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this, LandAndRegistActivity.class));
                    }

                    break;
                case R.id.nav_theme:
                    ShowUtil.toast(MainActivity.this, "nav_theme");
                    break;
                case R.id.nav_feekback:
                    ShowUtil.toast(MainActivity.this, "nav_feekback");
                    break;
                case R.id.nav_setting:
                    ShowUtil.toast(MainActivity.this, "nav_setting");
                    break;
                case R.id.nav_about:
                    ShowUtil.toast(MainActivity.this, "nav_about");
                    break;
            }
            return true;
        }
    };


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_drawable:
                drawer_layout.openDrawer(GravityCompat.START);
                break;
            case R.id.nav_head_circle:

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    startActivity(new Intent(MainActivity.this, ExitLogInActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LandAndRegistActivity.class));
                }
                break;
        }
    }

}
