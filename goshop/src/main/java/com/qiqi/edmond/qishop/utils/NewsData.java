package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class NewsData {
    private NewsInfo data = new NewsInfo();
    private int code;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(NewsInfo data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public NewsInfo getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
