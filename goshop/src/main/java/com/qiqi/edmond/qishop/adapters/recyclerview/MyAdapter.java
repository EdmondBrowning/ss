package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseNormalAdapter;

import java.util.List;

/**
 * Created by edmond on 16-9-18.
 */
public class MyAdapter extends BaseNormalAdapter<String> {
    public MyAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_home,parent,false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseItem item,int position) {

    }

    class MyItem extends BaseItem{
        public MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }
}
