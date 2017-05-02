package com.qiqi.edmond.qishop.tool;

/**
 * Created by edmond on 17-1-25.
 */

public class MathTools {
    public static int findMax(int[] numbers){
        int max = Integer.MIN_VALUE;
        if(numbers.length>=0){
            for(int i=0;i<numbers.length;i++){
                if(numbers[i]>max){
                    max = numbers[i];
                }
            }
            return max;
        }else{
            return 0;
        }
    }
}
