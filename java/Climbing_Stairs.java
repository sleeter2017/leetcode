// https://leetcode.com//problems/climbing-stairs/#/description		 QuestionId:70
import java.io.*; 
import java.util.*; 
public class Solution {
    public int climbStairs(int n) {
        int []memo = new int[n+1];
        return climbStairs(n, memo);
    }
    
    public int climbStairs(int n, int[] memo) {
        if(n < 0) {
            return 0;
        } else if ( n == 0 || n == 1) {
            return 1;
        } else if (memo[n] > 0) {
            return memo[n];
        } else {
            memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
            return memo[n];
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Note: Given n will be a positive integer.
*/