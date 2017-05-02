package com.qiqi.xznview.layout;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qiqi.xznview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 16-8-5.
 */
public class XZBannerLayout extends LinearLayout implements ViewPager.OnPageChangeListener{

    private Context context;
    private ViewPager viewPager;
    private LinearLayout indicator;
    private TextView bannerTitle;
    private TextView numIndicator;
    private TimeThread timeThread;
    private int count;
    private List<Banner> banners;
    private List<ImageView> indicatorImages = new ArrayList<>();
    private int lastPosition = 1;

    private int delayTime = 2000;

    private static final String TAG = "MyBannerLayout";
    public static final int TYPE_CIRCLE = 1;
    public static final int TYPE_TITLE = 2;
    public static final int TYPE_NUMBER = 3;

    private int type = TYPE_CIRCLE;

    private OnBannerClickListener onBannerClickListener;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        }
    };

    public XZBannerLayout(Context context) {
        this(context,null);
    }

    public XZBannerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context, attrs);
    }

    private void initView(Context context,AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.banner_layout,this,true);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        indicator = (LinearLayout) view.findViewById(R.id.indicator);
        bannerTitle = (TextView) view.findViewById(R.id.bannerTitle);
        numIndicator = (TextView) view.findViewById(R.id.numIndicator);
        viewPager.setOnPageChangeListener(this);
    }

    public void setBanners(List<Banner> banners){
        if(timeThread!=null){
            timeThread.isStop = true;
        }
        this.banners = banners;
        Log.d(TAG, String.valueOf(banners.size()));
        count = banners.size();
        viewPager.setAdapter(new MyBannerAdapter(context,banners));
        createIndicator();
        timeThread = new TimeThread();
        timeThread.start();
    }

    private void createIndicator() {
        switch (type){
            case TYPE_CIRCLE:
                indicator.removeAllViews();
                for (int i = 0; i < count; i++) {
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    LayoutParams params = new LayoutParams(15,15);
                    params.leftMargin = 5;
                    params.rightMargin = 5;
                    if(i==0){
                        imageView.setImageResource(R.drawable.gray_radius);
                    }else{
                        imageView.setImageResource(R.drawable.white_radius);
                    }
                    indicator.addView(imageView, params);
                    indicatorImages.add(imageView);
                }

                indicator.setVisibility(View.VISIBLE);
                break;
            case TYPE_NUMBER:
                numIndicator.setVisibility(View.VISIBLE);
                break;
            case TYPE_TITLE:
                bannerTitle.setVisibility(View.VISIBLE);
                bannerTitle.setText(banners.get(viewPager.getCurrentItem()).getTitle());
                break;
        }
    }

    public void setType(int type){
        this.type = type;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (type){
            case TYPE_CIRCLE:
                Log.d(TAG+"P", String.valueOf(position));
                indicatorImages.get((lastPosition +count)%count).setImageResource(R.drawable.white_radius);
                indicatorImages.get((position+count)%count).setImageResource(R.drawable.gray_radius);
                lastPosition=position;
                break;
            case TYPE_NUMBER:
                numIndicator.setText(((position+count)%count+1)+"/"+count);
                break;
            case TYPE_TITLE:
                bannerTitle.setText(banners.get((position+count)%count).getTitle());
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.onBannerClickListener = onBannerClickListener;
    }

    class TimeThread extends Thread{
        private boolean isStop = false;
        @Override
        public void run() {
            super.run();
            while(!isStop){
                handler.sendEmptyMessage(0);
                try {
                    Thread.sleep(delayTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyBannerAdapter extends PagerAdapter {
        private Context context;
        private List<Banner> banners;

        public MyBannerAdapter(Context context, List<Banner> banners){
            this.banners = banners;
            this.context = context;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            int index = position%banners.size();
            Log.d(TAG+"Adapter"+position, String.valueOf(banners.get(index).getImage()));
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, container, false);
            ImageView image = (ImageView) view.findViewById(R.id.banner);
            Glide.with(context)
                    .load(banners.get(index).getImage())
                    .centerCrop()
                    .crossFade()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onBannerClickListener!=null)
                        onBannerClickListener.OnBannerClick(view,position);
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    public interface OnBannerClickListener {
        void OnBannerClick(View view, int position);
    }

    public static class Banner {
        private String title;
        private String image;
        private int nid;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setNid(int nid) {
            this.nid = nid;
        }

        public int getNid() {
            return nid;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImage() {
            return image;
        }

        public String getTitle() {
            return title;
        }
    }
}
