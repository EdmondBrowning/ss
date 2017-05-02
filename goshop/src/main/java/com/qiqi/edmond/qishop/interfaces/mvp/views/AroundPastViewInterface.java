package com.qiqi.edmond.qishop.interfaces.mvp.views;

import com.qiqi.edmond.qishop.utils.AroundPastInfo;
import com.qiqi.edmond.qishop.utils.AroundPastData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundPastViewInterface {
    void initing();
    void inited(AroundPastData result);
    void initError();

    void refreshing();
    void refreshed(AroundPastData result);
    void refreshError();

    void loadMoring();
    void loadMored(List<AroundPastInfo> result);
    void loadMoreError();
}
