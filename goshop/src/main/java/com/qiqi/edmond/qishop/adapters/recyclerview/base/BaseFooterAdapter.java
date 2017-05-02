package com.qiqi.edmond.qishop.adapters.recyclerview.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edmond on 16-9-18.
 */
public abstract class BaseFooterAdapter<T> extends BaseAdapter<T>{

    public BaseFooterAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public BaseAdapter.BaseItem onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseAdapter.BaseItem item = null;
        if(viewType==IS_FOOTER){
            item = initFooter(parent);
        }else{
            item = initItem(parent);
        }
        return item;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseItem item, int position) {
        if(position==getItemCount()-1){
            bindFooter(item);
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
        if(position==getItemCount()-1){
            result = IS_FOOTER;
        }else{
            result = IS_ITEM;
        }
        return result;
    }

    @Override
    public boolean isFull(int position) {
        if(position==getItemCount()-1)
            return true;
        return false;
    }

    public abstract Footer initFooter(ViewGroup parent);
    public abstract void bindFooter(BaseAdapter.BaseItem item);

    public abstract class Footer extends BaseAdapter.BaseItem{
        public Footer(View itemView) {
            super(itemView);
        }
    }

    public abstract class Item extends BaseAdapter.BaseItem{
        public Item(View itemView) {
            super(itemView);
        }
    }
}
