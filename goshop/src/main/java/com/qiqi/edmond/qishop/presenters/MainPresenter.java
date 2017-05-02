package com.qiqi.edmond.qishop.presenters;

import android.util.Log;

import com.qiqi.edmond.qishop.activitys.MainActivity;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.MainPresenterInterface;
import com.qiqi.edmond.qishop.models.MainModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;

/**
 * Created by edmond on 16-11-25.
 */

public class MainPresenter extends BasePresenter<MainActivity,MainModel> implements MainPresenterInterface{

    private final static String TAG = "MainPresenter";

    public MainPresenter(MainActivity view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited() {
        if(getView()!=null){
            getView().inited();
        }else{
            Log.d(TAG,"view is null");
            System.gc();
        }
    }
}
