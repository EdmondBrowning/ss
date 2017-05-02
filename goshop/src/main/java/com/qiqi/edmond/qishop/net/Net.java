package com.qiqi.edmond.qishop.net;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.download.DownloadQueue;
import com.yolanda.nohttp.rest.RequestQueue;

/**
 * Created by edmond on 16-12-14.
 */

public class Net {
    public static Net mInterface;

    public static RequestQueue requestQueue;

    public static DownloadQueue downloadQueue;

    private Net(){}

    public static void init(Application application) {
        mInterface = new Net();
        NoHttp.initialize(application);

        if(mInterface.requestQueue==null){
           mInterface.requestQueue = NoHttp.newRequestQueue();
        }

        if(mInterface.downloadQueue==null){
            mInterface.downloadQueue = NoHttp.newDownloadQueue();
        }
    }

    public static DownloadQueue getDownloadQueue() {
        return mInterface.downloadQueue;
    }

    public static RequestQueue getRequestQueue() {
        return mInterface.requestQueue;
    }


}
