package com.qiqi.edmond.qishop.interfaces.mvp.views;

import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-1-3.
 */

public interface ShoppingCartViewInterface {
    void initing();
    void inited(ShoppingCartData result);
    void initError();

    void refreshing();
    void refreshed(ShoppingCartData result);
    void refreshError();
}
