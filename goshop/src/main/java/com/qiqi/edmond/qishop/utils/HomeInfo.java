package com.qiqi.edmond.qishop.utils;

/**
 * Created by edmond on 17-1-22.
 */

public class HomeInfo {
    private String title;
    private String imageUrl;
    private int infoId;
    private String infoStr;

    public HomeInfo(){
        this("title",0);
    }

    public HomeInfo(String title,int infoId){
        this(title,infoId,"imageUrl");
    }

    public HomeInfo(String title,int infoId,String imageUrl){
        this(title,infoId,imageUrl,"infoStr");
    }

    public HomeInfo(String title,int infoId,String imageUrl,String infoStr){
        setTitle(title);
        setInfoId(infoId);
        setImageUrl(imageUrl);
        setInfoStr(infoStr);
    }

    public String getTitle() {
        return title;
    }

    public int getInfoId() {
        return infoId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInfoStr() {
        return infoStr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public void setInfoStr(String infoStr) {
        this.infoStr = infoStr;
    }
}
