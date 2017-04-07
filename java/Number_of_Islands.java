// https://leetcode.com//problems/number-of-islands/#/description		 QuestionId:200
import java.io.*; 
import java.util.*; 

/*
grid[i][j]<d in the base condition makes sure distance for room is not updated when it (one passed in recursive call) is more than the existing distance. It also serves as a stopping condition when met with obstacles, since -1 will always be less than any distance.
*/
public class Solution {
public int numIslands(char[][] grid) {
    int count = 0;
    for (int row = 0; row < grid.length; row++)
        for (int col = 0; col < grid[0].length; col++)
            if (grid[row][col] == '1') {
                dfs(grid, row, col);
                count++;
            }

    return count;
}

private void dfs(char[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || 
                                        col < 0 || col >= grid[0].length || 
                                                        grid[row][col] != '1') return;
    grid[row][col] = '0';
    // we can go in 4 different directions
    dfs(grid, row - 1, col);
    dfs(grid, row + 1, col);
    dfs(grid, row, col - 1);
    dfs(grid, row, col + 1);
 }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110110101100000000
Answer: 1
Example 2:
11000110000010000011
Answer: 3

Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.*/