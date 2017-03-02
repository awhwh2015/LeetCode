package pers.wh.leetcode.question3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghan on 2017/3/3.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        List<Character> charList = new ArrayList<Character>();
        int i = 0;
        int maxLength = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int index = charList.indexOf(c);
            if(index >= 0){
                maxLength = maxLength >= charList.size()?maxLength:charList.size();
                for(int j = index ; j >= 0 ; j --){
                    charList.remove(j);
                }
            }
            charList.add(c);
            i++;
        }
        maxLength = maxLength >= charList.size()?maxLength:charList.size();
        return maxLength;
    }
}