package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseHeaderAdapter;

import java.util.List;

/**
 * Created by edmond on 16-9-18.
 */
public class MyHeaderAdapter extends BaseHeaderAdapter<String> {

    private View view;

    public MyHeaderAdapter(Context context, List<String> data,View view) {
        super(context, data);
        this.view = view;
    }

    @Override
    public Header initHeader(ViewGroup parent) {
        return new MyHeader(this.view);
    }

    @Override
    public void bindHeader(BaseAdapter.BaseItem item) {

    }

    @Override
    public BaseAdapter<String>.BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_home,parent,false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter<String>.BaseItem item,int position) {

    }

    class MyItem extends Item{
        public MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class MyHeader extends Header{

        public MyHeader(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }
}
