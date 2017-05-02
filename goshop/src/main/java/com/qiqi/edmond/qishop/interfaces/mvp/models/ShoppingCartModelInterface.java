package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.ShoppingCartPresenter;
import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-1-15.
 */

public interface ShoppingCartModelInterface {
    void init(ShoppingCartPresenter presenter);
    void refresh(ShoppingCartPresenter presenter);
}
