// https://leetcode.com//problems/linked-list-cycle-ii/#/description		 QuestionId:142
import java.io.*; 
import java.util.*; 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // solution is from CTCI
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // find intersection
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.



Note: Do not modify the linked list.


Follow up:
Can you solve it without using extra space?
*/