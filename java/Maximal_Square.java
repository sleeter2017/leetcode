// https://leetcode.com//problems/maximal-square/#/description		 QuestionId:221
import java.io.*; 
import java.util.*; 
public class Solution {
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] dp = new int[m+1][n+1];
        // dp[row][col] represents the length of the square whose lower-right corner is located at (row,col)
        // dp[row][col] = Min of 3 adjacent cells: top, left, top-left
        
        for (int row = 1 ; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if(a[row-1][col-1] == '1') {
                    //(row,col) = Min((row-1, col-1), (row-1, col), (row, col-1)) + 1
                    dp[row][col] = Math.min(Math.min(dp[row][col-1] , dp[row-1][col-1]), dp[row-1][col]) + 1;
                    result = Math.max(dp[row][col], result); // update result
                }
            }
        }
        return result*result;
    }
}

/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.


For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4.


Credits:Special thanks to @Freezen for adding this problem and creating all test cases.*/