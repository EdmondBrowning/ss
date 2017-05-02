package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-2-25.
 */

public class ShoppingCartData {
    List<ShoppingCartInfo> shoppingCartInfos = new ArrayList<>();

    public void setShoppingCartInfos(List<ShoppingCartInfo> shoppingCartInfos) {
        this.shoppingCartInfos = shoppingCartInfos;
    }

    public List<ShoppingCartInfo> getShoppingCartInfos() {
        return shoppingCartInfos;
    }
}
