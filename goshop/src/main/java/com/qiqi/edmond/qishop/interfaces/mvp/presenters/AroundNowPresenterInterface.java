package com.qiqi.edmond.qishop.interfaces.mvp.presenters;

import com.qiqi.edmond.qishop.utils.News;
import com.qiqi.edmond.qishop.utils.NewsInfo;
import com.qiqi.edmond.qishop.utils.NewsData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundNowPresenterInterface {
    void initing();
    void inited(NewsData result);
    void initError();

    void refreshing();
    void refreshed(NewsData result);
    void refeshError();

    void loadMoring();
    void loadMored(List<News> result);
    void loadMoreError();
}
