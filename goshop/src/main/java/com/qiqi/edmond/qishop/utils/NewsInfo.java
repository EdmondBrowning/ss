package com.qiqi.edmond.qishop.utils;

import com.qiqi.xznview.layout.XZBannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public class NewsInfo {
    private List<News> news = new ArrayList<>();
    private List<XZBannerLayout.Banner> banner = new ArrayList<>();

    public void setBanner(List<XZBannerLayout.Banner> banner) {
        this.banner = banner;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<XZBannerLayout.Banner> getBanner() {
        return banner;
    }

    public List<News> getNews() {
        return news;
    }
}
