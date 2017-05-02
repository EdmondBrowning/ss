package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseHeaderFooterAdapter;
import com.qiqi.edmond.qishop.utils.News;

import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class NewsToutiaoAdapter extends BaseHeaderFooterAdapter<News> {
    public interface OnItemClickListener {
        void itemClick(View v, int position,int nid);
    }

    private OnItemClickListener onItemClickListener;

    private View footer;
    private View header;

    public NewsToutiaoAdapter(Context context, List<News> data, View header, View footer) {
        super(context, data);
        this.footer = footer;
        this.header = header;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Footer initFooter(ViewGroup parent) {
        return new MyFooter(footer);
    }

    @Override
    public Header initHeader(ViewGroup parent) {
        return new ToutiaoHeader(header);
    }

    @Override
    public void bindHeader(BaseAdapter.BaseItem item) {

    }

    @Override
    public void bindFooter(BaseAdapter.BaseItem item) {

    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_news_toutiao, parent, false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter.BaseItem item, final int position) {
        ((MyItem) item).titleTextView.setText(getData().get(position-1).getTitle());
        ((MyItem) item).commentTextView.setText(getData().get(position-1).getComment_count() + "");
        if(getData().get(position-1).getImages().size()>0){
        Glide.with(getContext()).load(getData().get(position-1).getImages().get(0))
                .centerCrop()
                .crossFade()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem) item).face);
        }

        if (onItemClickListener != null) {
            ((MyItem) item).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.itemClick(v, position-1,getData().get(position-1).getNid());
                }
            });
        }
    }

    class MyFooter extends Footer {
        public MyFooter(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class ToutiaoHeader extends Header {
        public ToutiaoHeader(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class MyItem extends Item {

        ImageView face;
        TextView titleTextView;
        TextView commentTextView;

        MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {
            face = (ImageView) view.findViewById(R.id.face);
            titleTextView = (TextView) view.findViewById(R.id.title);
            commentTextView = (TextView) view.findViewById(R.id.comment);
        }
    }
}
