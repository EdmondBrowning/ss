package com.qiqi.edmond.qishop.adapters.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseFooterAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseNormalAdapter;
import com.qiqi.edmond.qishop.utils.ShoppingCartInfo;
import com.qiqi.edmond.qishop.views.decoration.LinearLayoutItemDecoration;
import com.qiqi.xznview.view.CircleImageView;

import java.util.List;

/**
 * Created by edmond on 17-2-23.
 */

public class ShoppingCartAdapter extends BaseNormalAdapter<ShoppingCartInfo> {

    public interface OnItemClickListener{
        void itemClick(View view,int position);
        void editClick(View view,int position);
        void checkClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener;
    private ShoppingCartItemAdapter.OnItemClickListener onSonItemClickListener;

    public ShoppingCartAdapter(Context context, List<ShoppingCartInfo> data) {
        super(context, data);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnSonItemClickListener(ShoppingCartItemAdapter.OnItemClickListener onSonItemClickListener) {
        this.onSonItemClickListener = onSonItemClickListener;
    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_shopping_cart, parent, false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseAdapter.BaseItem item, final int position) {
        ShoppingCartItemAdapter adapter = new ShoppingCartItemAdapter(getContext(),getData().get(position).getShoppingCartItemInfoList(),position);
        adapter.setOnItemClickListener(onSonItemClickListener);

        ((MyItem)item).recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        ((MyItem)item).recyclerView.addItemDecoration(new LinearLayoutItemDecoration(getContext(),LinearLayoutItemDecoration.VERTICAL_LIST));
        ((MyItem)item).recyclerView.setAdapter(adapter);
        ((MyItem)item).nameTextView.setText(getData().get(position).getName());

        if (getData().get(position).isSelect()){
            ((MyItem)item).checkButton.setImageResource(R.drawable.ic_check_yes);
        }else{
            ((MyItem)item).checkButton.setImageResource(R.drawable.ic_check_no);
        }

        Glide.with(getContext()).load(getData().get(position).getIconUrl())
                .centerCrop()
                .crossFade()
                .dontAnimate()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem)item).iconImageView);

        if (onItemClickListener!=null){
            ((MyItem)item).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.itemClick(v,position);
                }
            });
            ((MyItem)item).editTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.editClick(v,position);
                }
            });
            ((MyItem)item).checkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.checkClick(v,position);
                }
            });
        }
    }

    class MyItem extends BaseItem{

        private RecyclerView recyclerView;
        private CircleImageView iconImageView;
        private TextView editTextView;
        private TextView nameTextView;
        private ImageButton checkButton;

        public MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            iconImageView = (CircleImageView) view.findViewById(R.id.icon);
            editTextView = (TextView) view.findViewById(R.id.edit);
            nameTextView = (TextView) view.findViewById(R.id.name);
            checkButton = (ImageButton) view.findViewById(R.id.check_button);
        }
    }
}
