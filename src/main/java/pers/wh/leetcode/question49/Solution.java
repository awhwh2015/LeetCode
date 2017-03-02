package pers.wh.leetcode.question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghan on 2017/3/3.
 */
public class Solution {

    private int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    /**
     * 可以通过素数来简化key 的计算
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();
        Map<Integer,List<String>> map = new HashMap<Integer, List<String>>();
        for(String str : strs){
            int key = 1;
            for(char c :str.toCharArray()){
                key *= prime[c - 'a'];
            }
            List<String> values = map.get(key);
            if(values == null){
                values = new ArrayList<String>();
                map.put(key,values);
            }
            values.add(str);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"tao","pit","cam","aid","pro","dog"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for(List<String> list : result){
            for (String s : list){
                System.out.print(s + " ");
            }
            System.out.println("");
        }
    }
}
