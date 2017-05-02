package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseHeaderAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseHeaderFooterAdapter;
import com.qiqi.edmond.qishop.utils.HomeInfo;

import java.util.List;

/**
 * Created by edmond on 17-3-5.
 */

public class MineAdapter extends BaseHeaderFooterAdapter<HomeInfo> {
    private View header;
    private View footer;

    public MineAdapter(Context context, List<HomeInfo> data,View header,View footer) {
        super(context, data);
        this.header = header;
        this.footer = footer;
    }

    @Override
    public Footer initFooter(ViewGroup parent) {
        return new MyFooter(footer);
    }

    @Override
    public Header initHeader(ViewGroup parent) {
        return new MyHeader(header);
    }

    @Override
    public void bindHeader(BaseAdapter.BaseItem item) {

    }

    @Override
    public void bindFooter(BaseAdapter.BaseItem item) {

    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_home,parent,false);
        return new MyHeader(view);
    }

    @Override
    public void bindItem(BaseAdapter.BaseItem item, int position) {

    }

    class MyHeader extends Header {

        public MyHeader(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class MyFooter extends Footer{
        public MyFooter(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class MyItem extends Item {

        ImageView imageView;
        TextView titleTextView;
        TextView infoTextView;

        MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {
            imageView = (ImageView) view.findViewById(R.id.image);
            titleTextView = (TextView) view.findViewById(R.id.title);
            infoTextView = (TextView) view.findViewById(R.id.info);
        }
    }
}
