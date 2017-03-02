package pers.wh.leetcode.question42;

/**
 * Created by wanghan on 2017/3/2.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 *
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */
public class Solution {

    public int trap(int[] height) {
        int result = 0;
        int max = 0;
        for(int i = 0; i < height.length; i ++){
            if(height[max] < height[i]){
                max = i;
            }
        }
        result += compute(height,0,max - 1,max);
        result += compute(height,max + 1,height.length - 1,max);

        return result;
    }

    private int compute(int[] height, int start, int end, int base){
        int result = 0;
        if (start >= end ){
            return 0;
        }
        int max = start;
        for(int i = start ; i <= end ; i ++){
            if(height[max] < height[i] ){
                max = i ;
            }
        }
        int s = start;
        int e = end;
        if(base > end){
            s = max;
            result += compute(height,start,max - 1 , max);
        }else if(base < start){
            e = max;
            result += compute(height,max + 1, end , max);
        }

        for(int i = s; i <= e; i++){
            result += (height[max] - height[i]);
        }

        return result;
    }
}