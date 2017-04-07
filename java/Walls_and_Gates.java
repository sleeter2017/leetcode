// https://leetcode.com//problems/walls-and-gates/#/description		 QuestionId:286
import java.io.*; 
import java.util.*; 
/*
rooms[i][j]<d in the base condition makes sure distance for room is not updated when it (one passed in recursive call) is more than the existing distance. It also serves as a stopping condition when met with obstacles, since -1 will always be less than any distance.
*/
public class Solution {
public void wallsAndGates(int[][] rooms) {
    for (int row = 0; row < rooms.length; row++)
        for (int col = 0; col < rooms[0].length; col++)
            if (rooms[row][col] == 0) dfs(rooms, row, col, 0);
}

private void dfs(int[][] rooms, int row, int col, int d) {
    if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] < d) return;
    rooms[row][col] = d;
    // we can go in 4 different directions
    dfs(rooms, row - 1, col, d + 1);
    dfs(rooms, row + 1, col, d + 1);
    dfs(rooms, row, col - 1, d + 1);
    dfs(rooms, row, col + 1, d + 1);
}
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/