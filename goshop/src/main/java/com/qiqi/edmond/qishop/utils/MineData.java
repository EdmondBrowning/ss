package com.qiqi.edmond.qishop.utils;

/**
 * Created by edmond on 17-2-20.
 */

public class MineData {
    private String logoUrl;
    private String userId;
    private String name;
    private int level;
    private int levelNumber;
    private int orderNumber;
    private int waitLiveNumber;
    private int livingNumber;
    private int transitNumber;
    private int writeNumber;

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setLivingNumber(int livingNumber) {
        this.livingNumber = livingNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTransitNumber(int transitNumber) {
        this.transitNumber = transitNumber;
    }

    public void setWaitLiveNumber(int waitLiveNumber) {
        this.waitLiveNumber = waitLiveNumber;
    }

    public void setWriteNumber(int writeNumber) {
        this.writeNumber = writeNumber;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getUserId() {
        return userId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getLivingNumber() {
        return livingNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTransitNumber() {
        return transitNumber;
    }

    public int getWaitLiveNumber() {
        return waitLiveNumber;
    }

    public int getWriteNumber() {
        return writeNumber;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
