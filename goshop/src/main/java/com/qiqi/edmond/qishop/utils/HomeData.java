package com.qiqi.edmond.qishop.utils;

import com.qiqi.xznview.layout.XZBannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-22.
 */

public class HomeData {
    private List<XZBannerLayout.Banner> bannerList = new ArrayList<>();
    private String contentUImageUrl;
    private List<HomeInfo> infoList = new ArrayList<>();

    public List<HomeInfo> getInfoList() {
        return infoList;
    }

    public List<XZBannerLayout.Banner> getBannerList() {
        return bannerList;
    }

    public String getContentUImageUrl() {
        return contentUImageUrl;
    }

    public void setBannerList(List<XZBannerLayout.Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public void setContentUImageUrl(String contentUImageUrl) {
        this.contentUImageUrl = contentUImageUrl;
    }

    public void setInfoList(List<HomeInfo> infoList) {
        this.infoList = infoList;
    }
}
