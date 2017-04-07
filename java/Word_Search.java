// https://leetcode.com//problems/word-search/#/description		 QuestionId:79
import java.io.*; 
import java.util.*; 
public class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i =0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                if(board[i][j] == word.charAt(0) && DFS(board,word,0,i,j))
                    return true;
        return false;            
    }
    
    private boolean DFS(char[][] board, String word, int cur, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || 
            board[row][col] != word.charAt(cur)) return false;
        if(cur == word.length()-1) return true;
        /*
        board[y][x] ^= 256 it's a marker that the letter at position x,y is a part of word we search.
        After board[y][x] ^= 256 the char became not a valid letter. After second board[y][x] ^= 256, it became a valid letter again.
        */
        board[row][col] ^= 256;  
        if( DFS(board,word,cur+1,row-1,col) ) return true;
        if( DFS(board,word,cur+1,row+1,col) ) return true;
        if( DFS(board,word,cur+1,row,col-1) ) return true;
        if( DFS(board,word,cur+1,row,col+1) ) return true;
        board[row][col] ^= 256;
        return false;
    }
}





// https://leetcode.com//problems/walls-and-gates/		 QuestionId:286
/*
rooms[i][j]<d in the base condition makes sure distance for room is not updated when it (one passed in recursive call) is more than the existing distance. It also serves as a stopping condition when met with obstacles, since -1 will always be less than any distance.
*/
/*
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
*/
// https://leetcode.com//problems/number-of-islands/             QuestionId:200

/*
grid[i][j]<d in the base condition makes sure distance for room is not updated when it (one passed in recursive call) is more than the existing distance. It also serves as a stopping condition when met with obstacles, since -1 will always be less than any distance.
*/
/*
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
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a 2D board and a word, find if the word exists in the grid.


The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.



For example,
Given board = 

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]


word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/