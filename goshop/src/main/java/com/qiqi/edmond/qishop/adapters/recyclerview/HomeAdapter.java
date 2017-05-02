package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseHeaderFooterAdapter;
import com.qiqi.edmond.qishop.utils.HomeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by edmond on 16-9-18.
 */
public class HomeAdapter extends BaseHeaderFooterAdapter<HomeInfo> {

    private View header;
    private View footer;
    private List<Integer> heights = new ArrayList<>();

    public HomeAdapter(Context context, List<HomeInfo> data, View header, View footer) {
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
    public BaseAdapter<HomeInfo>.BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_home,parent,false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter<HomeInfo>.BaseItem item,int position) {
        ((MyItem)item).titleTextView.setText(getData().get(position-1).getTitle());
        ((MyItem)item).infoTextView.setText(getData().get(position-1).getInfoStr());
        Glide.with(getContext()).load(getData().get(position-1).getImageUrl())
                .centerCrop()
                .crossFade()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem)item).imageView);
    }

    class MyHeader extends Header{

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

    class MyItem extends Item{

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
