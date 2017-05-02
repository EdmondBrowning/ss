package com.qiqi.edmond.qishop.interfaces.mvp.presenters;

import com.qiqi.edmond.qishop.utils.MineData;

/**
 * Created by edmond on 17-1-15.
 */

public interface MinePresenterInterface {
    void initing();
    void inited(MineData result);
    void initError();

    void refreshing();
    void refreshed(MineData result);
    void refreshError();
}
