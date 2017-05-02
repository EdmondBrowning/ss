package com.qiqi.edmond.qishop.interfaces.mvp.presenters;

import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-1-15.
 */

public interface ShoppingCartPresenterInterface {
    void initing();
    void inited(ShoppingCartData result);
    void initError();

    void refreshing();
    void refreshed(ShoppingCartData result);
    void refreshError();
}
