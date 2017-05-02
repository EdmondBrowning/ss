package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.MineFragment;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.MinePresenterInterface;
import com.qiqi.edmond.qishop.models.MineModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.utils.MineData;

/**
 * Created by edmond on 17-2-20.
 */

public class MinePresenter extends BasePresenter<MineFragment,MineModel> implements MinePresenterInterface {
    public MinePresenter(MineFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(MineData result) {
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
    public void refreshed(MineData result) {
        getView().refreshed(result);
    }

    @Override
    public void refreshError() {
        getView().refreshError();
    }
}
