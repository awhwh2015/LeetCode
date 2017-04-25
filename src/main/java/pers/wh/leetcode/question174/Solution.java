package pers.wh.leetcode.question174;

import java.util.*;

/**
 * Created by wanghan on 2017/4/22.
 */
public class Solution {

    /**
     * 通过 迪杰斯特拉算法 计算
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {


        Map<String,NodeHealth> map = new HashMap<String, NodeHealth>();

        //默认 dungeon 大小至少为 2 * 2
        int m = dungeon.length;
        int n = dungeon[0].length;
        int i = 0 ,j = 0;

        int min = dungeon[i][j];

        while(i != m - 1 || j != n - 1){

            String key = buildKey(i,j);
            NodeHealth node = map.get(key);
            Set<NodeHealth> set = new HashSet<NodeHealth>();
            if(node == null){
                node = new NodeHealth(i,j,dungeon[i][j]);
            }

            // 将下一步可达的点 放入map 中
            // 两种可能性 1.向右移动一步

            if(j + 1 < n){
                handle(i, j + 1, map, set, node.value, dungeon);
            }

            // 2. 向下移动一步
            if(i + 1 < m){
                handle(i+1,j,map,set,node.value,dungeon);
            }

            map.remove(key);

            //判断是否需要回溯
            NodeHealth max = Collections.max(set);
            NodeHealth preMax = Collections.max(map.values());
            if(max.value < preMax.value){
                max = preMax;
            }
            if(max.value < min){
                min = max.value;
            }
            i = max.i;
            j = max.j;
            for(String k : map.keySet()){
                System.out.print(k + "\t" + map.get(k).value + "\t");
            }
            System.out.println();

        }
        if(min >= 0){
            return 1;
        }else {
            return Math.abs(min) + 1;
        }
    }

    private static String buildKey(int i, int j){
        return i + "_" + j;
    }

    private static void handle(int i, int j, Map<String,NodeHealth> map, Set<NodeHealth> set,int value,int[][] dungeon){
        String key = buildKey(i, j);
        NodeHealth temp = map.get(key);
        if(temp == null || temp.value < value + dungeon[i][j]){
            temp = new NodeHealth(i,j, value + dungeon[i][j]);
        }
        map.put(key, temp);
        set.add(temp);
    }

    private static class NodeHealth implements Comparable{
        int i;
        int j;
        int value;

        NodeHealth(int i,int j,int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            NodeHealth that = (NodeHealth) o;

            if (i != that.i)
                return false;
            if (j != that.j)
                return false;
            return value == that.value;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + value;
            return result;
        }

        public int compareTo(Object o) {
            if(! (o instanceof NodeHealth)){
                return -1;
            }
            NodeHealth node = (NodeHealth)o;
            if(value < node.value){
                return -1;
            }else if(value == node.value){
                return 0;
            }else {
                return 1;
            }
        }
    }

    /**
     * 采用动态规划的方法
     * 设 d(i,j,m,n) 表示 到终点(m,n) 的最低消耗,那么从 (i,j) 到 (m,n) 无外乎两种可能:
     * 1. 从 (i,j) 直接到达 (m,n)
     * 2. 经过 (p,q) 到达 (m,n)
     * d(i,j,m,n) = min(c(i,j,m,n),d(i,j,p,q) + d(p,q,m,n))
     * 从而回到原有的问题,可以进行递归求解
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP2(int[][] dungeon) {
        return 0;
    }



    public static void main(String[] args) {
        int [][] dungeon = new int [][] {{19,14,-25,-20,-36},{-46,-72,-74,25,-24},{-38,-57,-38,-73,-23},{-12,1,-70,44,-98}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
