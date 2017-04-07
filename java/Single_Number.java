// https://leetcode.com//problems/single-number/#/description		 QuestionId:136
import java.io.*; 
import java.util.*; 
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num: nums) 
            res ^= num;
        
        return res;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an array of integers, every element appears twice except for one. Find that single one.


Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/