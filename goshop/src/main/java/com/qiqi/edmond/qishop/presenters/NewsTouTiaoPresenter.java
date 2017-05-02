package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.NewsToutiaoFragment;
import com.qiqi.edmond.qishop.models.NewsTouTiaoModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.AroundNowPresenterInterface;
import com.qiqi.edmond.qishop.utils.News;
import com.qiqi.edmond.qishop.utils.NewsInfo;
import com.qiqi.edmond.qishop.utils.NewsData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public class NewsTouTiaoPresenter extends BasePresenter<NewsToutiaoFragment,NewsTouTiaoModel> implements AroundNowPresenterInterface {
    public NewsTouTiaoPresenter(NewsToutiaoFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(NewsData result) {
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
    public void refreshed(NewsData result) {
        getView().refreshed(result);
    }

    @Override
    public void refeshError() {
        getView().refreshError();
    }

    @Override
    public void loadMoring() {
        getView().loadMoring();
        getModel().loadMore(this);
    }

    @Override
    public void loadMored(List<News> result) {
        getView().loadMored(result);
    }

    @Override
    public void loadMoreError() {
        getView().loadMoreError();
    }
}
