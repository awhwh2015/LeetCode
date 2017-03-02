package pers.wh.leetcode.question2;

/**
 * Created by wanghan on 2017/3/3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        int carryOver = 0;
        while(l1 != null || l2 != null){
            int a = 0;
            int b = 0;
            if(l1 != null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + carryOver;
            int digit = sum % 10 ;
            carryOver = sum / 10;
            ListNode tmp = new ListNode(digit);
            if(head == null){
                head = node = tmp;
            }else{
                node.next = tmp;
                node = node.next;
            }
        }
        if(carryOver > 0){
            node.next = new ListNode(carryOver);
            node = node.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }
}
