// https://leetcode.com//problems/wiggle-sort/#/description		 QuestionId:280
import java.io.*; 
import java.util.*; 
public class Solution {
    public void wiggleSort(int[] nums) {
    for (int i=1; i<nums.length; i++) {
        
        if ((i%2 == 1) == (nums[i-1] > nums[i])) {
            swap(nums,i);
        }
    }
 }
 
 public void swap(int[] nums, int i){
          int tmp=nums[i];
          nums[i]=nums[i-1];
          nums[i-1]=tmp;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/