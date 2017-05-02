package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.MineModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.net.BaseStringListener;
import com.qiqi.edmond.qishop.net.StringNetWork;
import com.qiqi.edmond.qishop.presenters.MinePresenter;
import com.qiqi.edmond.qishop.utils.MineData;

import static com.qiqi.edmond.qishop.net.Api.MINE_INIT;

/**
 * Created by edmond on 17-2-20.
 */

public class MineModel extends BaseModel<MineData> implements MineModelInterface {
    @Override
    public void init(final MinePresenter presenter) {
//        getData().setLevel(1);
//        getData().setLevelNumber(50);
//        getData().setName("Edmond");
//        getData().setOrderNumber(1);
//        getData().setWriteNumber(3);
//        getData().setTransitNumber(1);
//        getData().setLivingNumber(1);
//        getData().setLogoUrl("http://www.qqpk.cn/Article/UploadFiles/201212/20121207103308720.jpg");
//        presenter.inited(getData());

        StringNetWork stringNetWork = new StringNetWork(0, MINE_INIT, new BaseStringListener<MineData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, MineData response) {
                getData().setLevel(response.getLevel());
                getData().setLevelNumber(response.getLevelNumber());
                getData().setLivingNumber(response.getLivingNumber());
                getData().setLogoUrl(response.getLogoUrl());
                getData().setName(response.getName());
                getData().setOrderNumber(response.getOrderNumber());
                getData().setTransitNumber(response.getTransitNumber());
                getData().setUserId(response.getUserId());
                getData().setWaitLiveNumber(response.getWaitLiveNumber());
                getData().setWriteNumber(response.getWriteNumber());
                presenter.inited(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.initError();
            }

            @Override
            public void onFinish(int what) {

            }
        },null);
//        stringNetWork.doIt();
    }

    @Override
    public void refresh(final MinePresenter presenter) {
        StringNetWork stringNetWork = new StringNetWork(0, MINE_INIT, new BaseStringListener<MineData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, MineData response) {
                presenter.refreshed(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.refreshError();
            }

            @Override
            public void onFinish(int what) {

            }
        },null);
//        stringNetWork.doIt();
    }
}
