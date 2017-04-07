// https://leetcode.com//problems/house-robber/#/description		 QuestionId:198
import java.io.*; 
import java.util.*; 
public class Solution {
    
    /*
        public int rob(int[] num) {
        int[][] dp = new int[num.length + 1][2];
        for (int i = 1; i <= num.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = num[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[num.length][0], dp[num.length][1]);
    }
    
    dp[i][1] means we rob the current house and dp[i][0] means we don't,

    so it is easy to convert this to O(1) space
    */
    
    public int rob(int[] num) {
        int prevRobbedNo = 0;
        int prevRobbedYes = 0;
        for (int n : num) {
            int temp = prevRobbedNo;
            prevRobbedNo = Math.max(prevRobbedNo, prevRobbedYes);
            prevRobbedYes = n + temp;
        }
        return Math.max(prevRobbedNo, prevRobbedYes);
    }
}

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.*/