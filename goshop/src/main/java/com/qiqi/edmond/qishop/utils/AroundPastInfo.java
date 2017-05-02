package com.qiqi.edmond.qishop.utils;

/**
 * Created by edmond on 17-2-21.
 */

public class AroundPastInfo {
    private String logoUrl;
    private String name;
    private String title;
    private String time;
    private String faceUrl;
    private String script;
    private int watchingNumber;
    private int commentNumber;
    private int thumbNumber;
    private boolean isCollection;
    private boolean isCare;

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCare(boolean care) {
        isCare = care;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setThumbNumber(int thumbNumber) {
        this.thumbNumber = thumbNumber;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWatchingNumber(int watchingNumber) {
        this.watchingNumber = watchingNumber;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public int getThumbNumber() {
        return thumbNumber;
    }

    public int getWatchingNumber() {
        return watchingNumber;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public String getScript() {
        return script;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public boolean isCare() {
        return isCare;
    }
}
