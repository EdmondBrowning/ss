package com.qiqi.edmond.qishop.net;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by edmond on 16-12-16.
 */

public abstract class BaseJsonObjectNetWork {
    Request<JSONObject> request = null;
    BaseJsonObjectListener baseJsonObjectListener = null;
    Map<String,String> params = null;
    int what;

    public BaseJsonObjectNetWork(int what,String url, BaseJsonObjectListener listener,Map<String,String> map){
        this.what = what;
        this.params = map;
        this.baseJsonObjectListener = listener;

        this.request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
        request.add(params);
    }

    public void doIt(){
        Net.getRequestQueue().add(0, request, new OnResponseListener<JSONObject>() {
            @Override
            public void onStart(int what) {
                baseJsonObjectListener.onStart(what);
            }

            @Override
            public void onSucceed(int what, Response<JSONObject> response) {
                baseJsonObjectListener.format(what,response.get());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                baseJsonObjectListener.onFailed(what,url,tag,exception,responseCode,networkMillis);
            }

            @Override
            public void onFinish(int what) {
                baseJsonObjectListener.onFinish(what);
            }
        });
    }
}
