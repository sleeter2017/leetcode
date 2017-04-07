// https://leetcode.com//problems/kth-largest-element-in-an-array/#/description		 QuestionId:215
import java.io.*; 
import java.util.*; 
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b.compareTo(a));
        
        for(int num : nums) 
            maxHeap.add(num);
        
        for(; k > 1; k--)
            maxHeap.poll();
        
        return maxHeap.poll();
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
