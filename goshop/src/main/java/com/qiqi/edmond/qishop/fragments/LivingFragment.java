package com.qiqi.edmond.qishop.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.HomeAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.HomeViewInterface;
import com.qiqi.edmond.qishop.presenters.HomePresenter;
import com.qiqi.edmond.qishop.utils.HomeInfo;
import com.qiqi.edmond.qishop.utils.HomeData;
import com.qiqi.xznview.layout.XZBannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-3.
 */

public class LivingFragment extends Fragment implements HomeViewInterface{
    private static final String TAG = "LivingFragment";
    private static final int spanCount = 2;

    private View view;
    private View header;
    private View footer;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private XZBannerLayout bannerLayout;
    private ImageView imageView;

    private HomeAdapter adapter;
    private HomePresenter presenter;
    private Activity activity;

    private List<HomeInfo> data = new ArrayList<>();

    private LinearLayoutManager layoutManager;

    private AlertDialog.Builder builder = null;
    private AlertDialog dialog = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        presenter = new HomePresenter(this);

        view = inflater.inflate(R.layout.fragment_living,container,false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        header = LayoutInflater.from(activity).inflate(R.layout.header_home,null);
        footer = LayoutInflater.from(activity).inflate(R.layout.footer,null);

        imageView = (ImageView) header.findViewById(R.id.content);
        bannerLayout = (XZBannerLayout) header.findViewById(R.id.banner);
        bannerLayout.setType(XZBannerLayout.TYPE_NUMBER);

//        layoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HomeAdapter(activity,data,header,footer);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                layoutManager.invalidateSpanAssignments();
//                int[] lastItemPositions = null;
//                lastItemPositions = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPositions(lastItemPositions);
//                int lastItemPosition = MathTools.findMax(lastItemPositions);


//                int lastItemPosition = ((GridLayoutManager)recyclerView.getLayoutManager()).findLastVisibleItemPosition();
//                if(lastItemPosition==data.size()){
//                    presenter.loadMoring();
//                }
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshing();
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);

        presenter.initing();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    public void initing() {
        builder = new AlertDialog.Builder(this.getContext());
        View d = LayoutInflater.from(activity).inflate(R.layout.dialog_loading,null);
        dialog = builder.setView(d).create();
        dialog.show();
        Log.d(TAG,"init");
    }

    @Override
    public void inited(HomeData result) {
        data.addAll(result.getInfoList());

        adapter.notifyDataSetChanged();

        bannerLayout.setBanners(result.getBannerList());

        Glide.with(activity).load(result.getContentUImageUrl())
                .centerCrop()
                .crossFade()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(imageView);

        dialog.dismiss();
        footer.setVisibility(View.VISIBLE);
    }

    @Override
    public void initError() {
        dialog.dismiss();
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {
        Log.d(TAG,"refresh");
    }

    @Override
    public void refreshed(HomeData result) {
        data.clear();
        data.addAll(result.getInfoList());
        adapter.notifyDataSetChanged();

        bannerLayout.setBanners(result.getBannerList());

        Glide.with(activity).load(result.getContentUImageUrl())
                .centerCrop()
                .crossFade()
                .placeholder(com.qiqi.xznview.R.mipmap.ic_launcher)
                .into(imageView);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void refreshError() {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadMoring() {
        Log.d(TAG,"More");
    }

    @Override
    public void loadMored(List<HomeInfo> result) {
        data.addAll(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }
}
