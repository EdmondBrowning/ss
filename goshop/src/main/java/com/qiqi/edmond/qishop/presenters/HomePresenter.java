package com.qiqi.edmond.qishop.presenters;

import android.util.Log;

import com.qiqi.edmond.qishop.fragments.LivingFragment;
import com.qiqi.edmond.qishop.interfaces.mvp.views.HomeViewInterface;
import com.qiqi.edmond.qishop.models.HomeModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.HomePresenterInterface;
import com.qiqi.edmond.qishop.utils.HomeInfo;
import com.qiqi.edmond.qishop.utils.HomeData;

import java.util.List;

/**
 * Created by edmond on 17-1-15.
 */

public class HomePresenter extends BasePresenter<HomeViewInterface,HomeModel> implements HomePresenterInterface {
    private String TAG = "HomePresenter";

    public HomePresenter(LivingFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(HomeData result) {
        if(getView()!=null){
            getView().inited(result);
        }else{
            Log.d(TAG,"view is null");
            System.gc();
        }
    }

    @Override
    public void initError() {
        getView().initError();
    }

    @Override
    public void refreshing() {
        getView().refreshing();
        getModel().refresh(this);
    }

    @Override
    public void refreshed(HomeData result) {
        if(getView()!=null){
            getView().refreshed(result);
        }else{
            Log.d(TAG,"view is null");
            System.gc();
        }
    }

    @Override
    public void refreshError() {
        getView().refreshError();
    }

    @Override
    public void loadMoring() {
        getView().loadMoring();
        getModel().loadMore(this);
    }

    @Override
    public void loadMored(List<HomeInfo> result) {
        if(getView()!=null){
            getView().loadMored(result);
        }else{
            Log.d(TAG,"view is null");
            System.gc();
        }
    }

    @Override
    public void loadMoreError() {
        getView().loadMoreError();
    }
}
