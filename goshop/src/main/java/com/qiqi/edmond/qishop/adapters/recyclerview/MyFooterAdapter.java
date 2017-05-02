package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseFooterAdapter;

import java.util.List;

/**
 * Created by edmond on 16-9-18.
 */
public class MyFooterAdapter extends BaseFooterAdapter<String> {

    private View view;

    public MyFooterAdapter(Context context, List<String> data,View view) {
        super(context, data);
        this.view = view;
    }

    @Override
    public Footer initFooter(ViewGroup parent) {
        return new MyFooter(this.view);
    }

    @Override
    public void bindFooter(BaseAdapter.BaseItem item) {

    }

    @Override
    public BaseAdapter<String>.BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_home,parent,false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter<String>.BaseItem item,int position) {

    }

    class MyFooter extends Footer{
        public MyFooter(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class MyItem extends Item{

        public MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }
}
