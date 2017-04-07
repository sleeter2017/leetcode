// https://leetcode.com//problems/sort-colors/#/description		 QuestionId:75
import java.io.*; 
import java.util.*; 
//The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle
public class Solution {
    public void sortColors(int[] nums) {
        int second=nums.length-1, zero=0;
        
        for(int i=0; i<=second; i++) {
            // The following order is important, if we swap the order, will get wrong answer
            while(nums[i]==2 && i<second) { swap(nums,i,second); second--; }
            while(nums[i]==0 && i>zero ) { swap(nums,i,zero); zero++; }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.



Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.



Note:
You are not suppose to use the library's sort function for this problem.


click to show follow up.


Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?

*/