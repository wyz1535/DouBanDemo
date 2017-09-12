package com.leyifu.doubandemo.presenter;

import android.content.Context;

import com.leyifu.doubandemo.bean.top250.Top250Bean;
import com.leyifu.doubandemo.interf.DouBanApi;
import com.leyifu.doubandemo.interf.IgetTop250View;
import com.leyifu.doubandemo.util.ApiUtil;
import com.leyifu.doubandemo.util.ShowUtil;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by xingxing on 2017/9/11.
 */

public class DouBanPersenter {

    private Context context;

   public DouBanPersenter (Context context){
       this.context =context;
   }

    public void getTop250(IgetTop250View igetTop250View, Class<DouBanApi> douBanApiClass, int start, int count, boolean isLoadMore){
        Observable<Top250Bean> observable = ApiUtil.getRetrofir().create(douBanApiClass).getTop250Movie(start, count);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Top250Bean>() {
                    @Override
                    public void call(Top250Bean top250Bean) {
//                        List<SubjectsBean> subjects = top250Bean.getSubjects();
                        igetTop250View.getTop250Success(top250Bean,isLoadMore);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ShowUtil.toast(context, "网络错误");
                    }
                });
    }

}