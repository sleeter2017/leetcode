// https://leetcode.com//problems/bomb-enemy/#/description		 QuestionId:361
import java.io.*; 
import java.util.*; 
//https://discuss.leetcode.com/topic/48565/short-o-mn-solution
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = (rows > 0 ? grid[0].length : 0);
        int [] colhits = new int[cols];
        int rowhits = 0;
        
        for(int row = 0 ; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                //Travers entire row
                if( col == 0 || grid[row][col-1] == 'W') {
                    rowhits = 0; //reset
                    for(int i = col; i < cols && grid[row][i] !='W'; i++)
                        if(grid[row][i] == 'E') rowhits++;
                }
                
                //Traverse entire col
                if( row == 0 || grid[row-1][col] == 'W') {
                    colhits[col] = 0; //reset
                    for(int i = row; i < rows && grid[i][col] != 'W'; i++)
                        if(grid[i][col] == 'E') colhits[col]++;
                }
                if(grid[row][col] == '0') // can place bomb only in Empty space
                    result = Math.max(result, rowhits+colhits[col]);
            }
        }
        return result;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/