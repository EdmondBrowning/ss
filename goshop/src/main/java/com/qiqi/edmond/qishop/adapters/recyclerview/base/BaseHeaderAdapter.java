package com.qiqi.edmond.qishop.adapters.recyclerview.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edmond on 16-9-18.
 */
public abstract class BaseHeaderAdapter<T> extends BaseAdapter<T>{

    public BaseHeaderAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public BaseAdapter.BaseItem onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseAdapter.BaseItem item = null;
        if(viewType==IS_HEADER){
            item = initHeader(parent);
        }else{
            item = initItem(parent);
        }
        return item;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseItem item, int position) {
        if(position==0){
            bindHeader(item);
        }else{
            bindItem(item,position);
        }
    }


    @Override
    public int getItemCount() {
        return super.getItemCount()+1;
    }

    @Override
    public int getItemViewType(int position) {
        int result;
        if(position==0){
            result = IS_HEADER;
        }else{
            result = IS_ITEM;
        }
        return result;
    }

    @Override
    public boolean isFull(int position) {
        if(position == 0)
            return true;
        return false;
    }

    public abstract Header initHeader(ViewGroup parent);
    public abstract void bindHeader(BaseAdapter.BaseItem item);

    public abstract class Header extends BaseAdapter.BaseItem{
        public Header(View itemView) {
            super(itemView);
        }
    }

    public abstract class Item extends BaseAdapter.BaseItem{
        public Item(View itemView) {
            super(itemView);
        }
    }
}
