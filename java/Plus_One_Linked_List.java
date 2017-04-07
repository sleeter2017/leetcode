// https://leetcode.com//problems/plus-one-linked-list/#/description		 QuestionId:369
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
 
 /*
       Approach: Reverse, increment, Reverse
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode revHead = reverse(head);
        head = revHead;
        while(head != null) {
            if(head.val < 9) {
                head.val++;
                break;
            } else {
                head.val = 0;
            }
            
            head = head.next;
        }
        
        boolean extra = false;
        if(head == null) {
            // reached end, add new node with value 1
            extra = true;
        }
        
        head = reverse(revHead);
        if(extra) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        
        ListNode tail = null;
        

        ListNode prev = head; head = head.next;
        while(head != null) {
            prev.next = tail;
            tail = prev;
            prev = head;
            head = head.next;
        }
        prev.next = tail;
        tail = prev;
        return tail;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/