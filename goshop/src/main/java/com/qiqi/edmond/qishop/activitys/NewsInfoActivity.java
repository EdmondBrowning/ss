package com.qiqi.edmond.qishop.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.activitys.base.BaseActivity;
import com.qiqi.edmond.qishop.adapters.ViewPagerAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-4-30.
 */

public class NewsInfoActivity extends BaseActivity {

    private ViewPager viewPager;
    private ArrayList<View> views = new ArrayList<>();
    private WebView webView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);

        View info = getLayoutInflater().inflate(R.layout.view_info,null);
        View comment = getLayoutInflater().inflate(R.layout.view_comment,null);

        recyclerView = (RecyclerView) comment.findViewById(R.id.recyclerView);

        webView = (WebView) info.findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.loadDataWithBaseURL(null,getNewContent("<html><body>dfjksdjfklsdfj施展<img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/><img src=\"http://img05.tooopen.com/images/20150202/sy_80219211654.jpg\"/></body></html>"),"text/html","charset=UTF-8", null);


        views.add(info);
        views.add(comment);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(views));
    }

    private String getNewContent(String htmltext){

        Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width","100%").attr("height","auto");
        }

        Log.d("VACK", doc.toString());
        return doc.toString();
    }
}
