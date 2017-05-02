package com.qiqi.edmond.qishop.activitys;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qiqi.edmond.qishop.MyApplication;
import com.qiqi.edmond.qishop.R;
import com.qiqi.edmond.qishop.activitys.base.BaseActivity;
import com.qiqi.edmond.qishop.application.BaseApplication;

/**
 * Created by edmond on 17-3-6.
 */

public class WelcomeActivity extends BaseActivity {

    private ImageView first;
    private TextView name;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        first = (ImageView) findViewById(R.id.first);
        name = (TextView) findViewById(R.id.name);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(0);
            }
        }.start();

        final int screenHeight = ((MyApplication)getApplication()).getHeight();
        final int screenWidth = ((MyApplication)getApplication()).getWidth();

        ValueAnimator animator = new ValueAnimator();
        animator.setTarget(first);
        animator.setObjectValues(new PointF(0,0),new PointF(0,screenHeight/2));
        animator.setDuration(5000);
        animator.setEvaluator(new TypeEvaluator<PointF>() {
            boolean isFail = true;
            float g =  ((float)screenHeight*4.0f)/5.0f/0.5f/0.5f;
            float vp = screenWidth/2.0f-100.0f;
            float vh = 0.0f;
            float vhtemp = 0.0f;
            float f = 0.0f;
            float ftemp = 0.0f;
            float y = 0.0f;
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF point = new PointF();
                if(vhtemp<=0&&!isFail){
                    y = first.getY();
                    isFail = true;
                    f = fraction;
                }
                if(y+0.5f * g * ((fraction-f) * 4) * ((fraction-f) * 4)>=screenHeight*2/5&&isFail){
                    isFail = false;
                    Log.d("TAg", "set False"+Math.sqrt(2)/2.0f+"*"+vh);
                    vh = (float) (vhtemp * Math.sqrt(2)/2);
                    f = fraction;
                }

                if(isFail){
                    point.y = y + 0.5f * g * ((fraction - f) * 4) * ((fraction -f)* 4);//下落
                    vhtemp = vhtemp + g*(fraction-ftemp)*4.0f;
                    Log.d("VH",""+vhtemp);
                }else{
                    //上升
                    Log.d("TAG","risa"+(fraction-f));
                    point.y = screenHeight*2/5 - vh*((fraction-f)*4)+0.5f * g * ((fraction - f) * 4) * ((fraction -f )* 4);
                    vhtemp = vhtemp - (fraction - ftemp)*g*4.0f;
                }
                ftemp = fraction;
                point.x = vp*fraction;
                Log.d("TAg", point.x+":"+screenWidth/2);
                name.setAlpha(fraction);
                return point;
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                first.setY(point.y);
                RelativeLayout.LayoutParams layoutParams =  new RelativeLayout.LayoutParams(200, 200);
                layoutParams.setMargins((int) point.x,0,0,0);
                first.setLayoutParams(layoutParams);
            }
        });
        animator.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}
