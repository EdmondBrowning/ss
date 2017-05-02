package com.qiqi.edmond.qishop.net;

import android.os.Environment;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.download.DownloadListener;
import com.yolanda.nohttp.download.DownloadRequest;

import java.io.File;
import java.util.Map;

/**
 * Created by edmond on 16-12-16.
 */

public abstract class BaseDownloadNetWork {
    DownloadRequest request = null;
    BaseDownloadListener baseDownLoadListener = null;
    Map<String,String> params = null;
    String fileFolder = null;
    String fileName = null;
    int what;

    public BaseDownloadNetWork(int what,String url, String fileFolder, String fileName ,BaseDownloadListener listener,Map<String,String> map){
        this.what = what;
        this.params = map;
        this.baseDownLoadListener = listener;
        this.fileFolder = fileFolder;
        this.fileName = fileName;

        request = NoHttp.createDownloadRequest(url, fileFolder,fileName,true,true);
        request.add(params);
    }

    public void start(){
        Net.getDownloadQueue().add(what, request, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
                baseDownLoadListener.onDownloadError(what,exception);
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                baseDownLoadListener.onStart(what,isResume,rangeSize,responseHeaders,allCount);
            }

            @Override
            public void onProgress(int what, int progress, long fileCount) {
                baseDownLoadListener.onProgress(what,progress,fileCount);
            }

            @Override
            public void onFinish(int what, String filePath) {
                baseDownLoadListener.onFinish(what,filePath);
            }

            @Override
            public void onCancel(int what) {
                baseDownLoadListener.onCancel(what);
            }
        });
    }

    public void pause(){
        request.cancel();
    }

    public void resume(){
        Net.getDownloadQueue().add(what, request, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
                baseDownLoadListener.onDownloadError(what,exception);
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                baseDownLoadListener.onStart(what,isResume,rangeSize,responseHeaders,allCount);
            }

            @Override
            public void onProgress(int what, int progress, long fileCount) {
                baseDownLoadListener.onProgress(what,progress,fileCount);
            }

            @Override
            public void onFinish(int what, String filePath) {
                baseDownLoadListener.onFinish(what,filePath);
            }

            @Override
            public void onCancel(int what) {
                baseDownLoadListener.onCancel(what);
            }
        });
    }

    public void cancel(){
        request.cancel();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),fileName+".nohttp");
        if (file.isFile() && file.exists()) {
            file.delete();
        }else if((file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),fileName)).isFile()&&file.exists()){
            file.delete();
        }
    }
}
