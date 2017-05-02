package com.qiqi.edmond.qishop.interfaces.mvp.presenters;

import com.qiqi.edmond.qishop.utils.AroundWillInfo;
import com.qiqi.edmond.qishop.utils.AroundWillData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundWillPresenterInterface {
    void initing();
    void inited(AroundWillData result);
    void initError();

    void refreshing();
    void refreshed(AroundWillData result);
    void refreshError();

    void loadMoring();
    void loadMored(List<AroundWillInfo> result);
    void loadMoreError();
}
