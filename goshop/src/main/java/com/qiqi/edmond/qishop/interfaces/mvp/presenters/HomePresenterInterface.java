package com.qiqi.edmond.qishop.interfaces.mvp.presenters;

import com.qiqi.edmond.qishop.utils.HomeInfo;
import com.qiqi.edmond.qishop.utils.HomeData;

import java.util.List;

/**
 * Created by edmond on 17-1-15.
 */

public interface HomePresenterInterface {
    void initing();
    void inited(HomeData result);
    void initError();

    void refreshing();
    void refreshed(HomeData result);
    void refreshError();

    void loadMoring();
    void loadMored(List<HomeInfo> result);
    void loadMoreError();
}
