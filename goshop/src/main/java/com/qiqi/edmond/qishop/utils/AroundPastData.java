package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class AroundPastData {
    private String lastId;
    private List<AroundPastInfo> aroundPastInfos = new ArrayList<>();

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public void setAroundPastInfos(List<AroundPastInfo> aroundPastInfos) {
        this.aroundPastInfos = aroundPastInfos;
    }

    public String getLastId() {
        return lastId;
    }

    public List<AroundPastInfo> getAroundPastInfos() {
        return aroundPastInfos;
    }
}
