package com.qiqi.edmond.qishop.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.MineAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.MineViewInterface;
import com.qiqi.edmond.qishop.presenters.MinePresenter;
import com.qiqi.edmond.qishop.utils.HomeInfo;
import com.qiqi.edmond.qishop.utils.MineData;
import com.qiqi.edmond.qishop.views.decoration.GridLayoutItemDecoration;
import com.qiqi.xznview.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-3.
 */

public class MineFragment extends Fragment implements MineViewInterface{
    private RecyclerView recyclerView = null;
    private View view = null;
    private Toolbar toolbar = null;
    private RecyclerView toolRecyclerView = null;
    private ArrayList<ToolClass>  arrayList = new ArrayList<>();
    private ToolAdapter toolAdapter = null;
    private SwipeRefreshLayout swipeRefreshLayout = null;

    private TextView nameText = null;
    private TextView orderNumberText = null;
    private TextView waitLivingNumberText = null;
    private TextView livingNumberText = null;
    private TextView transitNumberText = null;
    private TextView writeNumberText = null;
    private TextView levelText = null;
    private TextView levelNextText = null;
    private CardView orderHeader = null;
    private CircleImageView logoImageView = null;
    private ProgressBar progressBar = null;

    private MinePresenter presenter;

    private Activity activity;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine,container,false);
        activity = getActivity();
        presenter = new MinePresenter(this);

        setHasOptionsMenu(true);

        nameText = (TextView) view.findViewById(R.id.name);
        levelText = (TextView) view.findViewById(R.id.lv);
        levelNextText = (TextView) view.findViewById(R.id.lv_next);
        logoImageView = (CircleImageView) view.findViewById(R.id.logo);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.getMenu().clear();
        toolbar.setLogo(R.drawable.ic_icon);
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);

        View header = inflater.inflate(R.layout.header_mine,container,false);
        View footer = inflater.inflate(R.layout.footer_mine,container,false);

        orderHeader = (CardView) header.findViewById(R.id.order_header);
        orderHeader.setNestedScrollingEnabled(false);
        orderNumberText = (TextView) header.findViewById(R.id.order_number_text);
        waitLivingNumberText = (TextView) header.findViewById(R.id.wait_number_text);
        livingNumberText = (TextView) header.findViewById(R.id.living_number_text);
        transitNumberText = (TextView) header.findViewById(R.id.transit_number_text);
        writeNumberText = (TextView) header.findViewById(R.id.write_number_text);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshing();
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);

        arrayList.add(new ToolClass(R.drawable.ic_collection,"我的收藏"));
        arrayList.add(new ToolClass(R.drawable.ic_care,"我的关注"));
        arrayList.add(new ToolClass(R.drawable.ic_statistics,"统计"));
        arrayList.add(new ToolClass(R.drawable.ic_card,"卡券"));
        arrayList.add(new ToolClass(R.drawable.ic_look_history,"浏览记录"));
        arrayList.add(new ToolClass(R.drawable.ic_overcome,"售后"));
        arrayList.add(new ToolClass(R.drawable.ic_my_device,"我的设备"));
        arrayList.add(new ToolClass(R.drawable.ic_my_place,"我的地址"));
        arrayList.add(new ToolClass(R.drawable.ic_vip,"Vip"));
        arrayList.add(new ToolClass(R.drawable.ic_class,"更多"));

        toolAdapter = new ToolAdapter(activity,arrayList);
        toolAdapter.setOnItemClickListener(new ToolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Log.d("TAG","0");
                        break;
                    case 1:
                        Log.d("TAG","1");
                        break;
                    case 2:
                        Log.d("TAG","2");
                        break;
                    case 3:
                        Log.d("TAG","3");
                        break;
                    case 4:
                        Log.d("TAG","4");
                        break;
                    case 5:
                        Log.d("TAG","5");
                        break;
                    case 6:
                        Log.d("TAG","6");
                        break;
                    case 7:
                        Log.d("TAG","7");
                        break;
                    case 8:
                        Log.d("TAG","8");
                        break;
                    case 9:
                        Log.d("TAG","9");
                        break;
                }
            }
        });

        toolRecyclerView = (RecyclerView) header.findViewById(R.id.tool_recycler);
        toolRecyclerView.setLayoutManager(new GridLayoutManager(activity,3));
        toolRecyclerView.setAdapter(toolAdapter);
        toolRecyclerView.addItemDecoration(new GridLayoutItemDecoration(activity));
        toolRecyclerView.setNestedScrollingEnabled(false);

        List<HomeInfo> list = new ArrayList<>();
        list.add(new HomeInfo());
        list.add(new HomeInfo());
        list.add(new HomeInfo());
        list.add(new HomeInfo());
        list.add(new HomeInfo());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(activity,2));
        recyclerView.setAdapter(new MineAdapter(activity,list,header,footer));
        recyclerView.setNestedScrollingEnabled(false);

        presenter.initing();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.d("Mine","dfd");
        menu.clear();
        inflater.inflate(R.menu.menu_mine, menu);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    public void initing() {

    }

    @Override
    public void inited(MineData result) {
        nameText.setText(result.getName());
        if(result.getOrderNumber()==0)
            orderNumberText.setVisibility(View.INVISIBLE);
        else
            orderNumberText.setText(result.getOrderNumber()+"");
        if(result.getWaitLiveNumber()==0)
            waitLivingNumberText.setVisibility(View.INVISIBLE);
        else
            waitLivingNumberText.setText(result.getWaitLiveNumber()+"");
        if(result.getLivingNumber()==0)
            livingNumberText.setVisibility(View.INVISIBLE);
        else
            livingNumberText.setText(result.getLivingNumber()+"");
        if(result.getTransitNumber()==0)
            transitNumberText.setVisibility(View.INVISIBLE);
        else
            transitNumberText.setText(result.getTransitNumber()+"");
        if(result.getWriteNumber()==0)
            writeNumberText.setVisibility(View.INVISIBLE);
        else
            writeNumberText.setText(result.getWriteNumber()+"");

        levelText.setText("Lv"+result.getLevel());
        levelNextText.setText("Lv"+(result.getLevel()+1));

        progressBar.setProgress(result.getLevelNumber());

        Glide.with(activity)
                .load(result.getLogoUrl())
                .centerCrop()
                .crossFade()
                .dontAnimate()
                .placeholder(R.mipmap.ic_launcher)
                .into(logoImageView);
    }

    @Override
    public void initError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {

    }

    @Override
    public void refreshed(MineData result) {
        swipeRefreshLayout.setRefreshing(false);
        inited(result);
    }

    @Override
    public void refreshError() {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    private static class ToolAdapter extends RecyclerView.Adapter<ViewHolder> {

        private Context context;
        private List<ToolClass> data;
        private LayoutInflater inflater;
        private OnItemClickListener onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public interface OnItemClickListener{
            void onItemClick(View view, int position);
        }

        public ToolAdapter(Context context,List<ToolClass> data){
            this.context = context;
            this.data = data;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_tool,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.imageView.setImageResource(data.get(position).getImageId());
            holder.textView.setText(data.get(position).getText());
            if(onItemClickListener!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, position);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }

    class ToolClass{
        private int imageId;
        private String text;

        public ToolClass(int imageId,String text){
            setImageId(imageId);
            setText(text);
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public int getImageId() {
            return imageId;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

}
