package com.qiqi.edmond.qishop.models;

import android.util.Log;

import com.qiqi.edmond.qishop.interfaces.mvp.models.HomeModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.net.Api;
import com.qiqi.edmond.qishop.net.BaseStringListener;
import com.qiqi.edmond.qishop.net.StringNetWork;
import com.qiqi.edmond.qishop.presenters.HomePresenter;
import com.qiqi.edmond.qishop.utils.HomeData;
import com.qiqi.edmond.qishop.utils.HomeInfoMore;

import java.util.HashMap;

/**
 * Created by edmond on 17-1-15.
 */

public class HomeModel extends BaseModel<HomeData> implements HomeModelInterface {

    @Override
    public void init(final HomePresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","1");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.HOME_INIT, new BaseStringListener<HomeData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, HomeData response) {
                Log.d("TAG++++++", String.valueOf(response.getBannerList().size()));
                getData().setBannerList(response.getBannerList());
                getData().setInfoList(response.getInfoList());
                getData().setContentUImageUrl(response.getContentUImageUrl());
                presenter.inited(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.initError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }

    @Override
    public void refresh(final HomePresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","1");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.HOME_INIT, new BaseStringListener<HomeData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, HomeData response) {
                Log.d("TAG++++++", String.valueOf(response.getBannerList().size()));
                getData().setBannerList(response.getBannerList());
                getData().setInfoList(response.getInfoList());
                getData().setContentUImageUrl(response.getContentUImageUrl());
                presenter.refreshed(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.refreshError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }

    @Override
    public void loadMore(final HomePresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","1");
        map.put("token","");
        map.put("lastId","1");

        StringNetWork stringNetWork = new StringNetWork(0, Api.HOME_MORE, new BaseStringListener<HomeInfoMore>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, HomeInfoMore response) {
                getData().getInfoList().addAll(response.getInfoList());
                presenter.loadMored(response.getInfoList());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.loadMoreError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }
}
