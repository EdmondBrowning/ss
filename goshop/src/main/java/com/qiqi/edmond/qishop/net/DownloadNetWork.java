package com.qiqi.edmond.qishop.net;

import java.util.Map;

/**
 * Created by edmond on 16-12-16.
 */

public class DownloadNetWork extends BaseDownloadNetWork {
    public DownloadNetWork(int what, String url, String fileFolder, String fileName, BaseDownloadListener listener, Map<String, String> map) {
        super(what, url, fileFolder, fileName, listener, map);
    }
}
