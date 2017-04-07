// https://leetcode.com//problems/island-perimeter/#/description		 QuestionId:463
import java.io.*; 
import java.util.*; 
/*
2 pass approach
1)  Each 1 makes 4 perimeters. count total 1s, multiply by 4
2) each adjacent 1 removes 2 perimeter, find total adjacents
Total perimeter = (total 1s * 4) - (total adjacents * 2)
*/
public class Solution {
    public int islandPerimeter(int[][] grid) {
        // count total 1s
        int ones = 0;
        int adj = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++) {
                if(j > 0 && grid[i][j] == grid[i][j-1] && grid[i][j]==1) adj++; // count row adjacent
                if(grid[i][j] == 1) ones++;
            }
        
        // count column adjacents
        for(int j = 0; j < grid[0].length; j++) 
            for(int i = 0; i < grid.length; i++)
                if(i > 0 && grid[i][j] == grid[i-1][j] && grid[i][j]==1) adj++;
                
        return ((ones * 4) - (adj *2));
    }
}

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

*/
/*----------------------------------------------------------------------------------- 
 Problem: 
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:


*/