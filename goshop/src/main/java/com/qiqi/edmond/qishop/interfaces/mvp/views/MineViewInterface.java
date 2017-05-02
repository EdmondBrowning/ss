package com.qiqi.edmond.qishop.interfaces.mvp.views;

import com.qiqi.edmond.qishop.utils.MineData;

/**
 * Created by edmond on 17-1-3.
 */

public interface MineViewInterface {
    void initing();
    void inited(MineData result);
    void initError();

    void refreshing();
    void refreshed(MineData result);
    void refreshError();
}
