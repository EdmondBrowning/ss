package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseFooterAdapter;
import com.qiqi.edmond.qishop.utils.AroundWillInfo;

import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class AroundWillAdapter extends BaseFooterAdapter<AroundWillInfo> {
    public interface OnItemClickListener {
        void itemClick(View v, int position);

        void logoClick(View v, int position);

        void watchingClick(View v, int position);

        void commentClick(View v, int position);

        void thumbClick(View v, int position);

        void collectionClick(View v, int position);

        void careClick(View v, int position);
    }

    private OnItemClickListener onItemClickListener;

    private View footer;

    public AroundWillAdapter(Context context, List<AroundWillInfo> data, View footer) {
        super(context, data);
        this.footer = footer;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public Footer initFooter(ViewGroup parent) {
        return new MyFooter(footer);
    }

    @Override
    public void bindFooter(BaseAdapter.BaseItem item) {

    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_around_will, parent, false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter.BaseItem item, final int position) {
        ((MyItem) item).titleTextView.setText(getData().get(position).getTitle());
        ((MyItem) item).timeTextView.setText(getData().get(position).getTime());
        ((MyItem) item).scriptTextView.setText(getData().get(position).getScript());
        ((MyItem) item).nameTextView.setText(getData().get(position).getName());
        ((MyItem) item).watchingTextView.setText(getData().get(position).getWatchingNumber() + "");
        ((MyItem) item).commentTextView.setText(getData().get(position).getCommentNumber() + "");
        ((MyItem) item).thumbTextView.setText(getData().get(position).getThumbNumber() + "");
        if (getData().get(position).isCollection()) {
            ((MyItem) item).collectionButton.setImageResource(R.drawable.ic_collection_full_y);
        }else {
            ((MyItem) item).collectionButton.setImageResource(R.drawable.ic_collection_full);
        }
        if (getData().get(position).isCare()) {
            ((MyItem) item).careButton.setImageResource(R.drawable.ic_care_full_y);
        }else {
            ((MyItem) item).careButton.setImageResource(R.drawable.ic_care_full);
        }
        Glide.with(getContext()).load(getData().get(position).getFaceUrl())
                .centerCrop()
                .crossFade()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem) item).face);
        Glide.with(getContext()).load(getData().get(position).getLogoUrl())
                .centerCrop()
                .crossFade()
                .dontAnimate()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem) item).icon);

        if (onItemClickListener != null) {
            ((MyItem) item).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.itemClick(v, position);
                }
            });
            ((MyItem) item).icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.logoClick(v, position);
                }
            });
            ((MyItem) item).watchingTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.watchingClick(v, position);
                }
            });
            ((MyItem) item).commentTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.commentClick(v, position);
                }
            });
            ((MyItem) item).thumbTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.thumbClick(v, position);
                }
            });
            ((MyItem) item).collectionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.collectionClick(v, position);
                }
            });
            ((MyItem) item).careButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.careClick(v, position);
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

    class MyItem extends Item {

        ImageView icon;
        ImageView face;
        TextView titleTextView;
        TextView scriptTextView;
        TextView timeTextView;
        TextView nameTextView;
        TextView watchingTextView;
        TextView commentTextView;
        TextView thumbTextView;
        ImageButton collectionButton;
        ImageButton careButton;

        MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            face = (ImageView) view.findViewById(R.id.face);
            titleTextView = (TextView) view.findViewById(R.id.title);
            scriptTextView = (TextView) view.findViewById(R.id.script);
            timeTextView = (TextView) view.findViewById(R.id.time);
            nameTextView = (TextView) view.findViewById(R.id.name);
            watchingTextView = (TextView) view.findViewById(R.id.watching);
            commentTextView = (TextView) view.findViewById(R.id.comment);
            thumbTextView = (TextView) view.findViewById(R.id.thumb);
            collectionButton = (ImageButton) view.findViewById(R.id.collection);
            careButton = (ImageButton) view.findViewById(R.id.care);
        }
    }
}
