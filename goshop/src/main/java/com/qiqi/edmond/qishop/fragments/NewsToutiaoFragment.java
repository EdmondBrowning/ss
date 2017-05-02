package com.qiqi.edmond.qishop.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.activitys.NewsInfoActivity;
import com.qiqi.edmond.qishop.adapters.recyclerview.NewsToutiaoAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.AroundNowViewInterface;
import com.qiqi.edmond.qishop.models.NewsTouTiaoModel;
import com.qiqi.edmond.qishop.presenters.NewsTouTiaoPresenter;
import com.qiqi.edmond.qishop.utils.News;
import com.qiqi.edmond.qishop.utils.NewsInfo;
import com.qiqi.edmond.qishop.utils.NewsData;
import com.qiqi.xznview.layout.XZBannerLayout;

import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class NewsToutiaoFragment extends Fragment implements AroundNowViewInterface,NewsToutiaoAdapter.OnItemClickListener{

    private View view;
    private RecyclerView recyclerView;
    private View footer;
    private View header;
    private SwipeRefreshLayout swipeRefreshLayout;

    private NewsData data = new NewsData();

    private NewsToutiaoAdapter adapter;

    private NewsTouTiaoPresenter presenter;

    private Activity activity;

    private LinearLayoutManager layoutManager;

    private ProgressBar loadmore;
    private TextView loadText;

    private XZBannerLayout bannerLayout;

    private boolean isLoadMore = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_toutiao,container,false);
        activity = getActivity();

        presenter = new NewsTouTiaoPresenter(this);

        footer = LayoutInflater.from(activity).inflate(R.layout.footer,null);
        header = LayoutInflater.from(activity).inflate(R.layout.header_toutiao,null);

        loadmore = (ProgressBar) footer.findViewById(R.id.load_progress_bar);
        loadText = (TextView) footer.findViewById(R.id.load_text);

        bannerLayout = (XZBannerLayout) header.findViewById(R.id.banner);

        adapter = new NewsToutiaoAdapter(activity,data.getData().getNews(),header,footer);
        adapter.setOnItemClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(activity,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItemPosition= ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if(lastItemPosition==data.getData().getNews().size()&&isLoadMore){
                    presenter.loadMoring();
                }
            }
        });

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
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
        isLoadMore = false;
    }

    @Override
    public void inited(NewsData result) {
        data.getData().getNews().clear();
        data.getData().getNews().addAll(result.getData().getNews());
        adapter.notifyDataSetChanged();

        bannerLayout.setBanners(result.getData().getBanner());
        isLoadMore = true;
    }

    @Override
    public void initError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {
        isLoadMore = false;
    }

    @Override
    public void refreshed(NewsData result) {
        swipeRefreshLayout.setRefreshing(false);
        data.getData().getNews().clear();
        data.getData().getNews().addAll(result.getData().getNews());
        adapter.notifyDataSetChanged();

        bannerLayout.setBanners(result.getData().getBanner());
        isLoadMore = true;
    }

    @Override
    public void refreshError() {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadMoring() {
        isLoadMore = false;
    }

    @Override
    public void loadMored(List<News> result) {
        Log.d("","lo");
        data.getData().getNews().addAll(result);
        adapter.notifyDataSetChanged();
        if(result.size()< NewsTouTiaoModel.COUNT){
            isLoadMore = false;
            loadmore.setVisibility(View.GONE);
            loadText.setText("没有更多");
        }else{
            isLoadMore = true;
        }
    }

    @Override
    public void loadMoreError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemClick(View v, int position, int nid) {
        Intent intent = new Intent(activity, NewsInfoActivity.class);
        startActivity(intent);

    }
}
