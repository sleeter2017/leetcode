// https://leetcode.com//problems/3sum-smaller/#/description		 QuestionId:259
import java.io.*; 
import java.util.*; 
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        int count=0;
        Arrays.sort(nums);
        for(int i =0; i < nums.length-2; i++ ) {
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right) {
                if((nums[i] + nums[left] + nums[right]) < target) {
                    count+=right-left; // this is KEY
                    left++;
                } else right--;
            }
        }
        
        return count;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/