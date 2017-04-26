package pers.wh.leetcode.question43;

/**
 * Created by wanghan on 2017/4/25.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Note:
 *
 * 1.The length of both num1 and num2 is < 110.
 * 2.Both num1 and num2 contains only digits 0-9.
 * 3.Both num1 and num2 does not contain any leading zero.
 * 4.You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class Solution {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num1.length() + num2.length() - 1);
        int l1 = num1.length();
        int l2 = num2.length();
        int add = 0;
        for(int i = 0; i < l1 + l2 - 1; i ++){
            int sum = 0;
            for(int j = i ; j >= 0; j--){
                if(j < l1 && (i - j) < l2){
                    sum += (num1.charAt(l1 - j - 1) - '0') * (num2.charAt(l2 - i + j - 1) - '0');
                }
            }
            sum += add;
            add = sum / 10;
            sb.append(sum % 10);
        }
        if(add > 0){
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("457","14"));
    }
}
