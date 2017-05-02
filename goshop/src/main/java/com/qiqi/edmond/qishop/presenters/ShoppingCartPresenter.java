package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.KnowFragment;
import com.qiqi.edmond.qishop.models.ShoppingCartModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.ShoppingCartPresenterInterface;
import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-2-25.
 */

public class ShoppingCartPresenter extends BasePresenter<KnowFragment,ShoppingCartModel> implements ShoppingCartPresenterInterface {
    public ShoppingCartPresenter(KnowFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(ShoppingCartData result) {
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
    public void refreshed(ShoppingCartData result) {
        getView().refreshed(result);
    }

    @Override
    public void refreshError() {
        getView().refreshError();
    }
}
