package pers.wh.leetcode.question292;

/**
 * Created by wanghan on 2017/3/3.
 */
public class Solution {

    public static boolean canWinNim(int n) {

        return !(n % 4 == 0);
    }

    public static void main(String[] args) {
        System.out.println(-1 % 4);
        System.out.println(canWinNim(11));
        System.out.println(canWinNim(12));
        System.out.println(canWinNim(13));
    }
}
