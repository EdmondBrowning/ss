package com.qiqi.xznview.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiqi.xznview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taofangxin on 16/4/16.
 */
public class XZFlowLayout extends ViewGroup {
    private Context mContext;
    private int usefulWidth;
    private int lineSpacing = 0;
    private List<Integer> lineNumList = new ArrayList();
    private List<String> textList;
    private List<ViewInfo> hideView = new ArrayList<>();
    private boolean isOpen = false;
    private boolean showAll = true;
    private boolean isShow=false;
    private OnItemClickListener onItemClickListener;
    private int itemBackgroundResource;

    private int lineCount = 0;
    private int showNum = 0;
    private int showLine = 0;
    private int maxLine = 2;

    private ImageView button;

    interface OnItemClickListener{
        void OnItemClick(View view);
    }

    public XZFlowLayout(Context context) {
        this(context, null);
    }

    public XZFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XZFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
                R.styleable.XZFlowLayout);
        lineSpacing = mTypedArray.getDimensionPixelSize(
                R.styleable.XZFlowLayout_lineSpacing, 0);
        maxLine = mTypedArray.getInt(R.styleable.XZFlowLayout_maxLine,2);
        isShow=mTypedArray.getBoolean(R.styleable.XZFlowLayout_showAll,false);
        if(isShow==true){
            maxLine = Integer.MAX_VALUE;
        }
        mTypedArray.recycle();
    }

    public void setText(List<String> textList){
        this.textList = textList;
        showAll=true;
        isOpen = false;

        hideView.clear();
        removeAllViews();

        for(int i=0;i<this.textList.size();i++){
            int ranHeight = dip2px(mContext, 30);
            MarginLayoutParams lp = new MarginLayoutParams(LayoutParams.WRAP_CONTENT, ranHeight);
            lp.setMargins(dip2px(mContext, 10), 0, dip2px(mContext, 10), 0);
            TextView tv = new TextView(mContext);
            tv.setPadding(dip2px(mContext, 15), 0, dip2px(mContext, 15), 0);
            tv.setTextColor(Color.parseColor("#FF3030"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            tv.setText(textList.get(i));
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            if(itemBackgroundResource==0){
                tv.setBackgroundResource(R.drawable.bg_tag);
            }else {
                tv.setBackgroundResource(itemBackgroundResource);
            }
            addView(tv,lp);
            hideView.add(new ViewInfo(tv,lp));

            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null)
                        onItemClickListener.OnItemClick(view);
                }
            });
        }
        button = new ImageView(mContext);
        button.setBackgroundResource(R.mipmap.ic_launcher);
        MarginLayoutParams lp = new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(button,lp);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
            }
        });

        Log.d("TAg", String.valueOf(getChildCount()));

    }

    public void setItemBackgroundResource(int resource){
        this.itemBackgroundResource = resource;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("Measure", String.valueOf(getChildCount()));
        showNum=0;
        showLine=0;
        int mPaddingLeft = getPaddingLeft();
        int mPaddingRight = getPaddingRight();
        int mPaddingTop = getPaddingTop();
        int mPaddingBottom = getPaddingBottom();

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int lineUsed = mPaddingLeft + mPaddingRight;
        int lineY = mPaddingTop;
        int lineHeight = 0;
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            int spaceWidth = 0;
            int spaceHeight = 0;
            LayoutParams childLp = child.getLayoutParams();
            if (childLp instanceof MarginLayoutParams) {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, lineY);
                MarginLayoutParams mlp = (MarginLayoutParams) childLp;
                spaceWidth = mlp.leftMargin + mlp.rightMargin;
                spaceHeight = mlp.topMargin + mlp.bottomMargin;
            } else {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            spaceWidth += childWidth;
            spaceHeight += childHeight;

            if (lineUsed + spaceWidth > widthSize) {
                ++showLine;
                if((!isOpen)&&(showLine >= maxLine)&&(i!=this.getChildCount()-1)){
                    showAll = false;
                    continue;
                }
                if(i==getChildCount()-1) {
                    if ((showLine <= maxLine)) {
                        if (showAll)
                            continue;
                    }
                }
                lineY += lineHeight + lineSpacing;
                lineUsed = mPaddingLeft + mPaddingRight;
                lineHeight = 0;
            }
            if (showLine < maxLine) {
                ++showNum;
            }
            if (spaceHeight > lineHeight) {
                lineHeight = spaceHeight;
            }
            lineUsed += spaceWidth;
        }
        setMeasuredDimension(
                widthSize,
                heightMode == MeasureSpec.EXACTLY ? heightSize : lineY + lineHeight + mPaddingBottom
        );
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int mPaddingLeft = getPaddingLeft();
        int mPaddingRight = getPaddingRight();
        int mPaddingTop = getPaddingTop();

        int lineX = mPaddingLeft;
        int lineY = mPaddingTop;
        int lineWidth = r - l;
        usefulWidth = lineWidth - mPaddingLeft - mPaddingRight;
        int lineUsed = mPaddingLeft + mPaddingRight;
        int lineHeight = 0;
        int lineNum = 0;

        lineNumList.clear();
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if((!isOpen) && (i >= showNum && i < getChildCount()-1)){
                continue;
            }
            if (child.getVisibility() == GONE) {
                continue;
            }
            if(i==getChildCount()-1) {
                if ((showLine <= maxLine)) {
                    if (showAll)
                        continue;
                }
            }
            int spaceWidth = 0;
            int spaceHeight = 0;
            int left = 0;
            int top = 0;
            int right = 0;
            int bottom = 0;
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            LayoutParams childLp = child.getLayoutParams();
            if (childLp instanceof MarginLayoutParams) {
                MarginLayoutParams mlp = (MarginLayoutParams) childLp;
                spaceWidth = mlp.leftMargin + mlp.rightMargin;
                spaceHeight = mlp.topMargin + mlp.bottomMargin;
                left = lineX + mlp.leftMargin;
                top = lineY + mlp.topMargin;
                right = lineX + mlp.leftMargin + childWidth;
                bottom = lineY + mlp.topMargin + childHeight;
            } else {
                left = lineX;
                top = lineY;
                right = lineX + childWidth;
                bottom = lineY + childHeight;
            }
            spaceWidth += childWidth;
            spaceHeight += childHeight;

            if (lineUsed + spaceWidth > lineWidth) {
                lineNumList.add(lineNum);
                lineY += lineHeight + lineSpacing;
                lineUsed = mPaddingLeft + mPaddingRight;
                lineX = mPaddingLeft;
                lineHeight = 0;
                lineNum = 0;
                if (childLp instanceof MarginLayoutParams) {
                    MarginLayoutParams mlp = (MarginLayoutParams) childLp;
                    left = lineX + mlp.leftMargin;
                    top = lineY + mlp.topMargin;
                    right = lineX + mlp.leftMargin + childWidth;
                    bottom = lineY + mlp.topMargin + childHeight;
                } else {
                    left = lineX;
                    top = lineY;
                    right = lineX + childWidth;
                    bottom = lineY + childHeight;
                }
            }
            child.layout(left, top, right, bottom);
            lineNum ++;
            if (spaceHeight > lineHeight) {
                lineHeight = spaceHeight;
            }
            lineUsed += spaceWidth;
            lineX += spaceWidth;
        }
        // add the num of last line
        lineNumList.add(lineNum);
    }

//    /**
//     * resort child elements to use lines as few as possible
//     */
//    public void relayoutToCompress() {
//        int childCount = this.getChildCount();
//        if (0 == childCount) {
//            //no need to sort if flowlayout has no child view
//            return;
//        }
//        int count = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            count++;
//        }
//        View[] childs = new View[count];
//        int[] spaces = new int[count];
//        int n = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            childs[n] = v;
//            LayoutParams childLp = v.getLayoutParams();
//            int childWidth = v.getMeasuredWidth();
//            if (childLp instanceof MarginLayoutParams) {
//                MarginLayoutParams mlp = (MarginLayoutParams) childLp ;
//                spaces[n] = mlp.leftMargin + childWidth + mlp.rightMargin;
//            } else {
//                spaces[n] = childWidth;
//            }
//            n++;
//        }
//        int[] compressSpaces = new int[count];
//        for (int i = 0; i < count; i++) {
//            compressSpaces[i] = spaces[i] > usefulWidth ? usefulWidth : spaces[i];
//        }
//        sortToCompress(childs, compressSpaces);
//        this.removeAllViews();
//        for (View v : childList) {
//            this.addView(v);
//        }
//        childList.clear();
//    }

//    private void sortToCompress(View[] childs, int[] spaces) {
//        int childCount = childs.length;
//        int[][] table = new int[childCount + 1][usefulWidth + 1];
//        for (int i = 0; i < childCount +1; i++) {
//            for (int j = 0; j < usefulWidth; j++) {
//                table[i][j] = 0;
//            }
//        }
//        boolean[] flag = new boolean[childCount];
//        for (int i = 0; i < childCount; i++) {
//            flag[i] = false;
//        }
//        for (int i = 1; i <= childCount; i++) {
//            for (int j = spaces[i-1]; j <= usefulWidth; j++) {
//                table[i][j] = (table[i-1][j] > table[i-1][j-spaces[i-1]] + spaces[i-1]) ? table[i-1][j] : table[i-1][j-spaces[i-1]] + spaces[i-1];
//            }
//        }
//        int v = usefulWidth;
//        for (int i = childCount ; i > 0 && v >= spaces[i-1]; i--) {
//            if (table[i][v] == table[i-1][v-spaces[i-1]] + spaces[i-1]) {
//                flag[i-1] =  true;
//                v = v - spaces[i - 1];
//            }
//        }
//        int rest = childCount;
//        View[] restArray;
//        int[] restSpaces;
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i] == true) {
//                childList.add(childs[i]);
//                rest--;
//            }
//        }
//
//        if (0 == rest) {
//            return;
//        }
//        restArray = new View[rest];
//        restSpaces = new int[rest];
//        int index = 0;
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i] == false) {
//                restArray[index] = childs[i];
//                restSpaces[index] = spaces[i];
//                index++;
//            }
//        }
//        table = null;
//        childs = null;
//        flag = null;
//        sortToCompress(restArray, restSpaces);
//    }

//    /**
//     * add some blank view to make child elements look in alignment
//     */
//    public void relayoutToAlign() {
//        int childCount = this.getChildCount();
//        if (0 == childCount) {
//            //no need to sort if flowlayout has no child view
//            return;
//        }
//        int count = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            count++;
//        }
//        View[] childs = new View[count];
//        int[] spaces = new int[count];
//        int n = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            childs[n] = v;
//            LayoutParams childLp = v.getLayoutParams();
//            int childWidth = v.getMeasuredWidth();
//            if (childLp instanceof MarginLayoutParams) {
//                MarginLayoutParams mlp = (MarginLayoutParams) childLp ;
//                spaces[n] = mlp.leftMargin + childWidth + mlp.rightMargin;
//            } else {
//                spaces[n] = childWidth;
//            }
//            n++;
//        }
//        int lineTotal = 0;
//        int start = 0;
//        this.removeAllViews();
//        for (int i = 0; i < count; i++) {
//            if (lineTotal + spaces[i] > usefulWidth) {
//                int blankWidth = usefulWidth - lineTotal;
//                int end = i - 1;
//                int blankCount = end - start;
//                if (blankCount >= 0) {
//                    if (blankCount > 0) {
//                        int eachBlankWidth = blankWidth / blankCount;
//                        MarginLayoutParams lp = new MarginLayoutParams(eachBlankWidth, 0);
//                        for (int j = start; j < end; j++) {
//                            this.addView(childs[j]);
//                            BlankView blank = new BlankView(mContext);
//                            this.addView(blank, lp);
//                        }
//                    }
//                    this.addView(childs[end]);
//                    start = i;
//                    i --;
//                    lineTotal = 0;
//                } else {
//                    this.addView(childs[i]);
//                    start = i + 1;
//                    lineTotal = 0;
//                }
//            } else {
//                lineTotal += spaces[i];
//            }
//        }
//        for (int i = start; i < count; i++) {
//            this.addView(childs[i]);
//        }
//    }

//    /**
//     * use both of relayout methods together
//     */
//    public void relayoutToCompressAndAlign(){
//        this.relayoutToCompress();
//        this.relayoutToAlign();
//    }

//    /**
//     * cut the flowlayout to the specified num of lines
//     * @param line_num
//     */
//    public void specifyLines(int line_num) {
//        int childNum = 0;
//        if (line_num > lineNumList.size()) {
//            line_num = lineNumList.size();
//        }
//        for (int i = 0; i < line_num; i++) {
//            childNum += lineNumList.get(i);
//        }
//        List<View> viewList = new ArrayList<>();
//        for (int i = 0; i < childNum; i++) {
//            viewList.add(getChildAt(i));
//            removeView(getChildAt(i));
//        }
//        removeAllViews();
//        for (View v : viewList) {
//            addView(v);
//        }
//    }

    public void hide() {

        if(isOpen){
            for(int i = showNum;i<hideView.size();i++) {
                removeView(hideView.get(i).getView());
            }
            isOpen = false;
        }else{
            for(int i = showNum;i<hideView.size();i++){
                removeView(hideView.get(i).getView());
                addView(hideView.get(i).getView(),getChildCount()-1,hideView.get(i).getLp());
            }
            isOpen = true;
        }
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(super.generateDefaultLayoutParams());
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    class ViewInfo{
        private View view;
        private MarginLayoutParams lp;

        public ViewInfo(View view,MarginLayoutParams lp){
            this.view = view;
            this.lp = lp;
        }

        public void setLp(MarginLayoutParams lp) {
            this.lp = lp;
        }

        public void setView(View view) {
            this.view = view;
        }

        public MarginLayoutParams getLp() {
            return lp;
        }

        public View getView() {
            return view;
        }
    }
}
