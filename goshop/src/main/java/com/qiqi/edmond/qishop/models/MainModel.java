package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.MainModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.presenters.MainPresenter;
import com.qiqi.edmond.qishop.utils.InitResult;

/**
 * Created by edmond on 16-11-25.
 */

public class MainModel extends BaseModel<InitResult> implements MainModelInterface {
    @Override
    public void init(final MainPresenter presenter) {
        presenter.inited();
//        StringNetWork stringNetWork = new StringNetWork(0,"http://192.168.1.107:9080/thinkphp/",new BaseStringListener<InitResult>(){
//
//            @Override
//            public void onStart(int what) {
//
//            }
//
//            @Override
//            public void onSucceed(int what, InitResult response) {
//                presenter.inited();
//                Log.d("TAG",response.getTitle());
//            }
//
//            @Override
//            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//
//            }
//
//            @Override
//            public void onFinish(int what) {
//
//            }
//        },null);
//        stringNetWork.doIt();
//
//        JsonObjectNetWork jsonObjectNetWork = new JsonObjectNetWork(0,"http://192.168.1.107:9080/thinkphp/", new BaseJsonObjectListener<InitResult>() {
//            @Override
//            public void onStart(int what) {
//
//            }
//
//            @Override
//            public void onSucceed(int what, InitResult response) {
//                Log.d("JSon",response.getTitle());
//            }
//
//            @Override
//            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//
//            }
//
//            @Override
//            public void onFinish(int what) {
//
//            }
//        },null);
//        jsonObjectNetWork.doIt();
    }
}
