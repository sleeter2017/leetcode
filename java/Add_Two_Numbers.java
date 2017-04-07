// https://leetcode.com//problems/add-two-numbers/#/description		 QuestionId:2
import java.io.*; 
import java.util.*; 
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
        if(l1 == null || l2 == null)
            return l1 == null ? l2:l1;
        
        //now both lists are not null
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val; 
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry %10);
            cur = cur.next;
            carry /= 10;
        }
        if(carry > 0) cur.next = new ListNode(carry);
        return res.next;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/