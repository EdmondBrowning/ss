package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 16-9-25.
 */

public class InitResult {
    String title;
    String url;
    List<Person>  list;

    public InitResult(){
        title="";
        url = "";
        list = new ArrayList<>();
    }

    public void setList(List<Person> list) {
        this.list=list;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getList() {
        return list;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
