// https://leetcode.com//problems/jump-game/#/description		 QuestionId:55
import java.io.*; 
import java.util.*; 
public class Solution {
    
    
        public boolean canJump(int[] nums) {
        
            int lastgood = nums.length-1;
            for(int i = lastgood-1; i >= 0 ; i--) {
                if(nums[i] >= lastgood - i) // if I can reach lastgood from current pos, update lastgood
                    lastgood = i;
            }
            
            return lastgood == 0;
        }

}

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array of non-negative integers, you are initially positioned at the first index of the array.


Each element in the array represents your maximum jump length at that position. 


Determine if you are able to reach the last index.



For example:
A = [2,3,1,1,4], return true.


A = [3,2,1,0,4], return false.
*/