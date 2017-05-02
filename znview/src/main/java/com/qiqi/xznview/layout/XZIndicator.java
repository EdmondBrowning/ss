package com.qiqi.xznview.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiqi.xznview.R;

/**
 * Created by edmond on 16-4-12.
 */
public class XZIndicator extends LinearLayout{
    private Paint paint;
    private Path path;
    private int triangleWidth;
    private int triangleHeight;

    private static final float RADIO_TRIANGLE_WIDTH = 1.2f;
    private int initTranslationX;
    private int translationX;

    private int tableVisibleCount;
    private static final int COUNT_DEFAULT=3;

    private ViewPager viewPager;

    public XZIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Indicator);

        tableVisibleCount = a.getInt(R.styleable.Indicator_visible_tab_count,COUNT_DEFAULT);

        if(tableVisibleCount<0){
            tableVisibleCount = COUNT_DEFAULT;
        }

        a.recycle();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.slide));
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(new CornerPathEffect(3));
    }

    public XZIndicator(Context context) {
        this(context, null);
    }

    public interface PageOnChangeListener{
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
        public void onPageSelected(int position);
        public void onPageScrollStateChanged(int state);
    }

    public PageOnChangeListener mListener;

    public void setOnPageChangeListener(PageOnChangeListener listener){
        mListener = listener;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();

        canvas.translate(initTranslationX + translationX, getHeight());
        canvas.drawPath(path,paint);

        canvas.restore();

        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.d("onSize", String.valueOf(w));

        triangleWidth = (int) (w/tableVisibleCount/2*RADIO_TRIANGLE_WIDTH);
        initTranslationX = w/tableVisibleCount/2-triangleWidth/2;

        initTriangle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        int cCount = getChildCount();
        if(cCount==0)return;

        for(int i=0;i<cCount;i++){
            View view = getChildAt(i);
            LayoutParams lp = (LayoutParams) view.getLayoutParams();
            lp.weight=0;
            Log.d("Ind", String.valueOf(getScreeWidth()));
            lp.width = (getScreeWidth())/tableVisibleCount;
            view.setLayoutParams(lp);
        }
        setItemClickeEvent();
    }

    private void initTriangle() {
        triangleHeight = triangleWidth/6/4;

        path = new Path();
        path.moveTo(0,100);
        path.lineTo(triangleWidth, 0);

        path.lineTo(triangleWidth, -triangleHeight);
        path.lineTo(0,-triangleHeight);
        path.close();

    }

    public void scoll(int position, float positionOffset) {
        int tabWidth = getWidth()/tableVisibleCount;
        translationX = (int) (tabWidth*(positionOffset+position));

        if((position>=tableVisibleCount-2)&&positionOffset>0&&getChildCount()>tableVisibleCount){
            if(tableVisibleCount!=1) {
                this.scrollTo((position - (tableVisibleCount - 2)) * tabWidth + (int) (tabWidth * positionOffset), 0);
            }else{
                this.scrollTo(position*tabWidth+(int)(tabWidth*positionOffset),0);
            }
        }

        invalidate();
    }

    public int getScreeWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        return outMetrics.widthPixels;
    }

    public void setViewPager(ViewPager viewPager, int pos){
        this.viewPager = viewPager;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scoll(position,positionOffset);
                if(mListener!=null){
                    mListener.onPageScrolled(position,positionOffset,positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if(mListener!=null){
                    mListener.onPageSelected(position);
                }
                highLightTextView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(mListener!=null){
                    mListener.onPageScrollStateChanged(state);
                }
            }
        });
        viewPager.setCurrentItem(pos);
        highLightTextView(pos);
    }

    private void resetTetViewColor(){
        for(int i=0;i<getChildCount();i++){
            View view = getChildAt(i);
            if(view instanceof TextView){
                ((TextView) view).setTextColor(getResources().getColor(R.color.gray));
            }
        }
    }

    private void highLightTextView(int pos){
        resetTetViewColor();
        View view = getChildAt(pos);
        if(view instanceof TextView){
            ((TextView) view).setTextColor(getResources().getColor(R.color.slide));
        }
    }

    private void setItemClickeEvent(){
        int cCount = getChildCount();
        for(int i=0;i<cCount;i++){
            final int j = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(j);
                }
            });
        }
    }


}
