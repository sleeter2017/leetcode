// https://leetcode.com//problems/combination-sum-iv/#/description		 QuestionId:377
import java.io.*; 
import java.util.*; 
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int [] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return combinationSum4Helper(nums, target, memo);
        
    }
    
    public int combinationSum4Helper(int[] nums, int remain, int[] memo) {
        if(remain == 0) return 1; //found a combination
        
        if(memo[remain] != -1) return memo[remain];
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(remain >= nums[i])
                res += combinationSum4Helper(nums, remain-nums[i], memo);
        }
        memo[remain] = res;
        return res; 
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
 Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.



Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers? 

Credits:Special thanks to @pbrother for adding this problem and creating all test cases.*/