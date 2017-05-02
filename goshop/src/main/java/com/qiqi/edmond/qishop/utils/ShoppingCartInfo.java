package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-2-23.
 */

public class ShoppingCartInfo {
    private String name;
    private String iconUrl;
    private String storeId;
    private boolean isSelect;

    private List<ShoppingCartItemInfo> shoppingCartItemInfoList = new ArrayList<>();

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setShoppingCartItemInfoList(List<ShoppingCartItemInfo> shoppingCartItemInfoList) {
        this.shoppingCartItemInfoList = shoppingCartItemInfoList;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public List<ShoppingCartItemInfo> getShoppingCartItemInfoList() {
        return shoppingCartItemInfoList;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public String getStoreId() {
        return storeId;
    }

    public boolean isSelect() {
        return isSelect;
    }
}
