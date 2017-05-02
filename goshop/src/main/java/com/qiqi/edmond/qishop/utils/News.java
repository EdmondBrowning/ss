package com.qiqi.edmond.qishop.utils;

import java.util.List;

/**
 * Created by edmond on 17-4-30.
 */

public class News {
    private String title;
    private List<String> images;
    private int comment_count;
    private int nid;

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComment_count() {
        return comment_count;
    }

    public int getNid() {
        return nid;
    }

    public List<String> getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }
}
