// https://leetcode.com//problems/missing-number/#/description		 QuestionId:268
import java.io.*; 
import java.util.*; 
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        int n = nums.length;
        int nsum = n*(n+1)/2;
        
        return nsum - sum;
    }
}

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


For example,
Given nums = [0, 1, 3] return 2.



Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.*/