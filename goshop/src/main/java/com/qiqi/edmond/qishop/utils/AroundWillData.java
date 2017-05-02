package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class AroundWillData {
    private int lastId;
    private List<AroundWillInfo> aroundWillInfos = new ArrayList<>();

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public void setAroundWillInfos(List<AroundWillInfo> aroundWillInfos) {
        this.aroundWillInfos = aroundWillInfos;
    }

    public int getLastId() {
        return lastId;
    }

    public List<AroundWillInfo> getAroundWillInfos() {
        return aroundWillInfos;
    }
}
