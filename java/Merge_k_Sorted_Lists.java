// https://leetcode.com//problems/merge-k-sorted-lists/#/description		 QuestionId:23
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
Problem: Merge k Sorted Lists
Suppose the total number of nodes is n The total time complexity if (n * log k) .For a priority queue, insertion takes logK time
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<>((a,b) -> a.val - b.val);
        
        ListNode res = new ListNode(0);
        ListNode tail=res;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return res.next;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/