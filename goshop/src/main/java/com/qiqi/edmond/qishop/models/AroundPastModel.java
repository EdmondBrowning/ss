package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.AroundPastModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.net.Api;
import com.qiqi.edmond.qishop.net.BaseStringListener;
import com.qiqi.edmond.qishop.net.StringNetWork;
import com.qiqi.edmond.qishop.presenters.AroundPastPresenter;
import com.qiqi.edmond.qishop.utils.AroundPastData;
import com.qiqi.edmond.qishop.utils.AroundPastInfoMore;

import java.util.HashMap;

/**
 * Created by edmond on 17-2-21.
 */

public class AroundPastModel extends BaseModel<AroundPastData> implements AroundPastModelInterface {
    @Override
    public void init(final AroundPastPresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_PAST_INIT, new BaseStringListener<AroundPastData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundPastData response) {
                getData().getAroundPastInfos().addAll(response.getAroundPastInfos());
                getData().setLastId(response.getLastId());
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
    public void refresh(final AroundPastPresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_PAST_INIT, new BaseStringListener<AroundPastData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundPastData response) {
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
    public void loadMore(final AroundPastPresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");
        map.put("lastId","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_PAST_MORE, new BaseStringListener<AroundPastInfoMore>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundPastInfoMore response) {
                presenter.loadMored(response.getAroundPastInfos());
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
