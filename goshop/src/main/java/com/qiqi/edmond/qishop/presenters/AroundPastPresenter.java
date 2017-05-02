package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.AroundPastFragment;
import com.qiqi.edmond.qishop.models.AroundPastModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.AroundPastPresenterInterface;
import com.qiqi.edmond.qishop.utils.AroundPastInfo;
import com.qiqi.edmond.qishop.utils.AroundPastData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public class AroundPastPresenter extends BasePresenter<AroundPastFragment,AroundPastModel> implements AroundPastPresenterInterface {
    public AroundPastPresenter(AroundPastFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(AroundPastData result) {
        getView().inited(result);
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
    public void refreshed(AroundPastData result) {
        getView().refreshed(result);
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
    public void loadMored(List<AroundPastInfo> result) {
        getView().loadMored(result);
    }

    @Override
    public void loadMoreError() {
        getView().loadMoreError();
    }
}
