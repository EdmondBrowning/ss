package com.qiqi.edmond.qishop.adapters.recyclerview.base;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edmond on 16-9-13.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseItem>{
    public static final int IS_HEADER = 0;
    public static final int IS_ITEM = 1;
    public static final int IS_FOOTER = 2;

    private List<T> data;
    private Context context;
    private LayoutInflater inflater;

    public BaseAdapter(Context context,List<T> data){
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public List<T> getData(){
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Context getContext(){
        return context;
    }

    public LayoutInflater getInflater(){
        return inflater;
    }

    @Override
    public BaseItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return initItem(parent);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseItem item, int position) {
        bindItem(item,position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public abstract BaseItem initItem(ViewGroup parent);
    public abstract void bindItem(BaseItem item,int position);
    public abstract boolean isFull(int position);

    public abstract class BaseItem extends RecyclerView.ViewHolder{
        public BaseItem(View itemView) {
            super(itemView);
            initViews(itemView);
        }

        public abstract void initViews(View view);
    }

    //should be override
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //这里需要去判断是否是底部显示，顶部显示，还是两者都显示
                    if(isFull(position))
                        return ((GridLayoutManager) layoutManager).getSpanCount();
                    else
                        return 1;
                }
            });
        }
    }

    //should be override
    @Override
    public void onViewAttachedToWindow(BaseAdapter.BaseItem holder) {
        super.onViewAttachedToWindow(holder);

        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if(layoutParams !=null &&layoutParams instanceof StaggeredGridLayoutManager.LayoutParams){
            //这里需要去判断是否是底部显示，顶部显示，还是两者都显示
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            p.setFullSpan(isFull(holder.getLayoutPosition()));
        }
    }
}
