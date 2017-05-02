package com.qiqi.edmond.qishop.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.adapters.recyclerview.ShoppingCartAdapter;
import com.qiqi.edmond.qishop.adapters.recyclerview.ShoppingCartItemAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.ShoppingCartViewInterface;
import com.qiqi.edmond.qishop.presenters.ShoppingCartPresenter;
import com.qiqi.edmond.qishop.utils.ShoppingCartData;
import com.qiqi.edmond.qishop.utils.ShoppingCartInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-3.
 */

public class KnowFragment extends Fragment implements ShoppingCartViewInterface{
    private View view;
    private RecyclerView recyclerView;
    private ShoppingCartAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageButton checkButton;

    private Activity activity;
    private List<ShoppingCartInfo> data = new ArrayList<>();

    private ShoppingCartPresenter presenter;

    private boolean isSelect = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_know,container,false);
        activity = getActivity();

        presenter = new ShoppingCartPresenter(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        checkButton = (ImageButton) view.findViewById(R.id.check_button);

        adapter = new ShoppingCartAdapter(activity,data);
        adapter.setOnItemClickListener(new ShoppingCartAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View view, int position) {
                Log.d("ShoppingFragment","itemClick");
            }

            @Override
            public void editClick(View view, int position) {
                Log.d("ShoppingFragment","editClick");
            }

            @Override
            public void checkClick(View view, int position) {
                Log.d("ShoppingFragment","checkClick");
                if (isSelect){
                    isSelect = false;
                    checkButton.setImageResource(R.drawable.ic_check_no);
                }

                if(data.get(position).isSelect()){
                    //循环从列表中删除
                    data.get(position).setSelect(false);
                    for (int i=0;i<data.get(position).getShoppingCartItemInfoList().size();i++){
                        data.get(position).getShoppingCartItemInfoList().get(i).setSelect(false);
                    }
                }else{
                    //循环添加到列表中
                    data.get(position).setSelect(true);
                    for (int i=0;i<data.get(position).getShoppingCartItemInfoList().size();i++){
                        data.get(position).getShoppingCartItemInfoList().get(i).setSelect(true);
                    }
                    isCheck();
                }
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setOnSonItemClickListener(new ShoppingCartItemAdapter.OnItemClickListener() {
            @Override
            public void itemClick(View view,int fatherPosition, int position) {
                Log.d("ShoppingFragment",fatherPosition+"ItemItemClick"+position);
            }

            @Override
            public void checkClick(View view,int fatherPosition, int position) {
                if (isSelect){
                    isSelect = false;
                    checkButton.setImageResource(R.drawable.ic_check_no);
                }

                if(data.get(fatherPosition).isSelect()){
                    data.get(fatherPosition).setSelect(false);
                }

                if(data.get(fatherPosition).getShoppingCartItemInfoList().get(position).isSelect()){
                    //从列表中删除
                    data.get(fatherPosition).getShoppingCartItemInfoList().get(position).setSelect(false);
                }else {
                    //添加到列表中
                    data.get(fatherPosition).getShoppingCartItemInfoList().get(position).setSelect(true);
                    int i = 0;
                    for(;i<data.get(fatherPosition).getShoppingCartItemInfoList().size();i++){
                        if(data.get(fatherPosition).getShoppingCartItemInfoList().get(i).isSelect()){
                            continue;
                        }else{
                            break;
                        }
                    }
                    if(i==data.get(fatherPosition).getShoppingCartItemInfoList().size()){
                        data.get(fatherPosition).setSelect(true);
                        isCheck();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshing();
            }
        });
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelect){
                    isSelect = false;
                    checkButton.setImageResource(R.drawable.ic_check_no);
                    for(int i=0;i<data.size();i++){
                        data.get(i).setSelect(false);
                        for(int j=0;j<data.get(i).getShoppingCartItemInfoList().size();j++){
                            data.get(i).getShoppingCartItemInfoList().get(j).setSelect(false);
                        }
                    }
                }else{
                    isSelect = true;
                    checkButton.setImageResource(R.drawable.ic_check_yes);
                    for(int i=0;i<data.size();i++){
                        data.get(i).setSelect(true);
                        for(int j=0;j<data.get(i).getShoppingCartItemInfoList().size();j++){
                            data.get(i).getShoppingCartItemInfoList().get(j).setSelect(true);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        presenter.initing();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

    private void isCheck(){
        int j = 0;
        for(;j<data.size();j++){
            if(data.get(j).isSelect()){
                continue;
            }else {
                break;
            }
        }
        if(j==data.size()){
            isSelect = true;
            checkButton.setImageResource(R.drawable.ic_check_yes);
        }
    }

    @Override
    public void initing() {

    }

    @Override
    public void inited(ShoppingCartData result) {
        data.clear();
        data.addAll(result.getShoppingCartInfos());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initError() {
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {

    }

    @Override
    public void refreshed(ShoppingCartData result) {
        swipeRefreshLayout.setRefreshing(false);
        isSelect = false;
        data.clear();
        data.addAll(result.getShoppingCartInfos());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshError() {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(activity,"好像出了点问题",Toast.LENGTH_SHORT).show();
    }
}
