// https://leetcode.com//problems/wildcard-matching/#/description		 QuestionId:44
import java.io.*; 
import java.util.*; 
// Explanation: https://www.youtube.com/watch?v=3ZDZ-N0EPV0
/*
dp[row+1][col+1] = ?, chars match:  dp[row][col]   // take diagonal value
                 = *  dp[row+1][col] || dp[row][col+1]
                 = else false
*/
public class Solution {
    public boolean isMatch(String s, String p) {
    
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int col=0; col < p.length(); col++) 
            if(p.charAt(col) == '*')
                dp[0][col+1] = dp[0][col];
            

        for (int row = 0 ; row < s.length(); row++) {
            for (int col = 0; col < p.length(); col++) {
                if(p.charAt(col) == '?' || p.charAt(col) == s.charAt(row))
                    dp[row+1][col+1] = dp[row][col];
                else if ( p.charAt(col) == '*' )
                    dp[row+1][col+1] = dp[row+1][col] || dp[row][col+1];
                else
                    dp[row+1][col+1] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
