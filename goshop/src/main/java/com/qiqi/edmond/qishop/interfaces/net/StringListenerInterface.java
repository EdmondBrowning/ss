package com.qiqi.edmond.qishop.interfaces.net;

/**
 * Created by edmond on 16-12-16.
 */

public interface StringListenerInterface<T> {
    void format(int what,String response);
    void onStart(int what);
    void onSucceed(int what, T response);
    void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis);
    void onFinish(int what);
}
