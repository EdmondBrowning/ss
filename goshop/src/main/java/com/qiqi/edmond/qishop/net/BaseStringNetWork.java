package com.qiqi.edmond.qishop.net;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import java.util.Map;

/**
 * Created by edmond on 16-9-27.
 */

public abstract class BaseStringNetWork {
    Request<String> request = null;
    BaseStringListener baseStringListener;
    Map<String,String> params;
    int what;

    public BaseStringNetWork(int what,String url, BaseStringListener listener,Map<String,String> map) {
        this.what = what;
        this.params = map;
        this.baseStringListener = listener;

        request = NoHttp.createStringRequest(url, RequestMethod.POST);
        request.add(params);
    }

    public void doIt(){
        Net.getRequestQueue().add(what, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
                baseStringListener.onStart(what);
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                baseStringListener.format(what,response.get());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                baseStringListener.onFailed(what,url,tag,exception,responseCode,networkMillis);
            }

            @Override
            public void onFinish(int what) {
                baseStringListener.onFinish(what);
            }
        });
    }
}
