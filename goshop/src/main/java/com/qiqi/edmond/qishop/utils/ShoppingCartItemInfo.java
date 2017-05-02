package com.qiqi.edmond.qishop.utils;

/**
 * Created by edmond on 17-2-23.
 */

public class ShoppingCartItemInfo {
    private double singlePrice;
    private int count;
    private String name;
    private String goodId;
    private String script;
    private String faceUrl;
    private boolean isSelect;

    public void setName(String name) {
        this.name = name;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getSinglePrice() {
        return singlePrice;
    }

    public String getGoodId() {
        return goodId;
    }

    public String getScript() {
        return script;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public boolean isSelect() {
        return isSelect;
    }
}
