package pers.wh.leetcode.question423;

/**
 * Created by wanghan on 2017/4/26.
 *
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * Note:
 * 1.Input contains only lowercase English letters.
 * 2.Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * 3.Input length is less than 50,000.
 *
 */
public class Solution {

    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
            case 'z':
                //zero
                count[0]++;
                break;
            case 'o':
                //zero one two four
                count[1]++;
                break;
            case 'w':
                //two
                count[2]++;
                break;
            case 'h':
                //three eight
                count[3]++;
                break;
            case 'u':
                //four
                count[4]++;
                break;
            case 'f':
                //five four
                count[5]++;
                break;
            case 'x':
                //six
                count[6]++;
                break;
            case 's':
                //six and seven
                count[7]++;
                break;
            case 'g':
                //eight
                count[8]++;
                break;
            case 'i':
                // five six eight nine
                count[9]++;
                break;

            }

        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.originalDigits("owoztneoer"));
    }
}
