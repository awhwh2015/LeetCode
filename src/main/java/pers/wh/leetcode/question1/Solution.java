package pers.wh.leetcode.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghan on 2017/3/3.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length ; i++){
            map.put(nums[i], i);
        }
        int [] r = new int[2];
        for(int i=0; i < nums.length; i++){
            Integer result = map.get(target - nums[i]);
            if(result != null && result > i){
                r[0] = i + 1;
                r[1] = result  + 1;
                break;
            }
        }
        return r;
    }
}
