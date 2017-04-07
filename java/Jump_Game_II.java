// https://leetcode.com//problems/jump-game-ii/#/description		 QuestionId:45
import java.io.*; 
import java.util.*; 
public class Solution {
    public int jump(int[] nums) {
        int n= nums.length-1, step = 0, start = 0, end = 0;
        while(end < n) {
            step++;
            int maxend = end+1;
            for(int i = start; i <= end; i++) {
                if( nums[i] >= n - i) return step;
                maxend = Math.max(maxend, i + nums[i]);
            }
            start = end + 1;
            end = maxend;
        }
        return 0; // it will reach here only if we cannot land at the last index 
    }
}

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array of non-negative integers, you are initially positioned at the first index of the array.


Each element in the array represents your maximum jump length at that position. 


Your goal is to reach the last index in the minimum number of jumps.



For example:
Given array A = [2,3,1,1,4]


The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)



Note:
You can assume that you can always reach the last index.*/