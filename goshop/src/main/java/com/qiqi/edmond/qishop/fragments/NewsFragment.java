package com.qiqi.edmond.qishop.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiqi.edmond.qishop.R;
import com.qiqi.xznview.adapter.MyPagerAdapter;
import com.qiqi.edmond.qishop.interfaces.mvp.views.AroundViewInterface;

import java.util.ArrayList;

/**
 * Created by edmond on 17-1-3.
 */

public class NewsFragment extends Fragment implements AroundViewInterface{
    private View view;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news,container,false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        fragments.add(new NewsToutiaoFragment());
        fragments.add(new AroundWillFragment());
        fragments.add(new AroundPastFragment());

        viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(),fragments));
        viewPager.setOffscreenPageLimit(2);

        TabLayout.Tab tab1 = tabLayout.newTab();
        TabLayout.Tab tab2 = tabLayout.newTab();
        TabLayout.Tab tab3 = tabLayout.newTab();
        TabLayout.Tab tab4 = tabLayout.newTab();
        TabLayout.Tab tab5 = tabLayout.newTab();

        tab1.setText("头条");
        tab2.setText("第一");
        tab3.setText("第二");
        tab4.setText("第三");
        tab5.setText("第四");

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
        tabLayout.addTab(tab4);
        tabLayout.addTab(tab5);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

        return view;
    }
}
