package com.qiqi.edmond.qishop.adapters.recyclerview.base;

import android.content.Context;

import java.util.List;

/**
 * Created by edmond on 16-9-19.
 */
public abstract class BaseNormalAdapter<T> extends BaseAdapter<T>{
    public BaseNormalAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public boolean isFull(int position) {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return IS_ITEM;
    }
}
