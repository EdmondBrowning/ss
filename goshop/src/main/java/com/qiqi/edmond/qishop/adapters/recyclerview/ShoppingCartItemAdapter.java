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
import com.qiqi.edmond.qishop.adapters.recyclerview.base.BaseNormalAdapter;
import com.qiqi.edmond.qishop.utils.ShoppingCartItemInfo;

import java.util.List;

/**
 * Created by edmond on 17-2-23.
 */

public class ShoppingCartItemAdapter extends BaseNormalAdapter<ShoppingCartItemInfo> {

    public interface OnItemClickListener{
        void itemClick(View view,int fatherPosition,int position);
        void checkClick(View view,int fatherPosition,int position);
    }

    private OnItemClickListener onItemClickListener;
    private int fatherPosition;

    public ShoppingCartItemAdapter(Context context, List<ShoppingCartItemInfo> data,int fatherPosition) {
        super(context, data);
        this.fatherPosition = fatherPosition;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        View view = getInflater().inflate(R.layout.item_shopping_cart_item,parent,false);
        return new MyItem(view);
    }

    @Override
    public void bindItem(BaseItem item, final int position) {
        ((MyItem)item).name.setText(getData().get(position).getName());
        ((MyItem)item).script.setText(getData().get(position).getScript());
        ((MyItem)item).count.setText(getData().get(position).getCount()+"");
        ((MyItem)item).sum.setText(getData().get(position).getCount()*getData().get(position).getSinglePrice()+"");

        if (getData().get(position).isSelect()){
            ((MyItem)item).checkButton.setImageResource(R.drawable.ic_check_yes);
        }else{
            ((MyItem)item).checkButton.setImageResource(R.drawable.ic_check_no);
        }

        Glide.with(getContext()).load(getData().get(position).getFaceUrl())
                .centerCrop()
                .crossFade()
                .dontAnimate()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(((MyItem)item).faceView);

        if (onItemClickListener!=null){
            ((MyItem)item).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.itemClick(v,fatherPosition,position);
                }
            });

            ((MyItem)item).checkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.checkClick(v,fatherPosition,position);
                }
            });
        }
    }

    class MyItem extends BaseItem{

        private TextView name;
        private TextView script;
        private TextView count;
        private TextView sum;
        private ImageView faceView;
        private ImageButton checkButton;

        public MyItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {
            name = (TextView) view.findViewById(R.id.name);
            script = (TextView) view.findViewById(R.id.script);
            count = (TextView) view.findViewById(R.id.count);
            sum = (TextView) view.findViewById(R.id.sum);
            faceView = (ImageView) view.findViewById(R.id.face);
            checkButton = (ImageButton) view.findViewById(R.id.check_button);
        }
    }
}
