package com.qiqi.edmond.qishop.interfaces.net;

import com.yolanda.nohttp.Headers;

/**
 * Created by edmond on 16-12-16.
 */

public interface DownloadListenerInterface {
    void onDownloadError(int what, Exception exception);
    void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount);
    void onProgress(int what, int progress, long fileCount);
    void onFinish(int what, String filePath);
    void onCancel(int what);
}
