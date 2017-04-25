package pers.wh.leetcode.question278;

/**
 * Created by wanghan on 2017/4/25.
 */
public class Solution extends VersionControl{

    public int firstBadVersion(int n) {

        long start = 1;
        long end = n;
        while(start != end ){
            long middle = (start + end) / 2;
            if(isBadVersion((int)middle)){
                end = middle;
            }else{
                start = middle + 1;
            }
            System.out.println(start + "\t" + end);
        }
        return (int)start;

//        return computeVersion(1,n);
    }

    public int computeVersion(int start, int end){
        if(start == end && isBadVersion(end)){
            return start;
        }
        long middle = (start + end) / 2;
        if(isBadVersion((int)middle)){
            return computeVersion(start,(int)middle);
        }else{
            return computeVersion((int)middle + 1,end);
        }

    }

    @Override
    boolean isBadVersion(int version) {
        if(version >= 1702766719){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(2126753390));
    }
}
