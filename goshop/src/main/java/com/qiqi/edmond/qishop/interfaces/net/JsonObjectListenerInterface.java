package com.qiqi.edmond.qishop.interfaces.net;

import org.json.JSONObject;

/**
 * Created by edmond on 16-12-16.
 */

public interface JsonObjectListenerInterface<T> {
    void format(int what,JSONObject response);
    void onStart(int what);
    void onSucceed(int what, T response);
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);
    void onFinish(int what);
}
