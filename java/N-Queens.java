// https://leetcode.com//problems/n-queens/#/description		 QuestionId:51
import java.io.*; 
import java.util.*; 
/*
  https://discuss.leetcode.com/topic/8592/comparably-concise-java-code
 https://discuss.leetcode.com/topic/8592/comparably-concise-java-code/8

 Using three boolean[] to replace three hashSet is a great idea.
 
 And we can use
    id1=rowCur+j
    id2=j-rowCur+n-1, it's more easy to understand.

 For every element arr[i][j] in diag line with positive slope,
 i+j is the same,it range from 0 to 2*(n-1).
 And for every element arr[i][j] in diag line with negative slope,
 j-i is the same,
 it range from -(n-1) to n-1,
 we add n-1 to make the range from 0 to 2*(n-1).
 */

public class Solution {


        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<List<String>>();
            if(n<1)
                return result;
            solve(result, new ArrayList<String>(), n, 0,new boolean[n], new boolean[2*n], new boolean[2*n]);
            return result;
        }
        public static void solve(List<List<String>> result, List<String> cur,
                          int n, int row, boolean[] column, boolean[] diag1,
                          boolean[] diag2){
            /* base case: If all queens are placed
           then return */
            if(row==n){
                result.add(new ArrayList<String>(cur));
                return;
            }

            /* Consider this column and try placing this queen in all columns one by one */
            for(int col = 0; col<n; col++){
                int id1=row+col;
                int id2=col-row+(n-1);

                /* Check if queen can be placed on col2[row] */
                if(!column[col] && !diag1[id1] && !diag2[id2]){
                    column[col]= diag1[id1]= diag2[id2]=true; // mark as safe

                    char[] helpChars=new char[n];
                    Arrays.fill(helpChars,'.');
                    /* Place this queen in board[row][column] */
                    helpChars[col]='Q';
                    cur.add(new String(helpChars));

                    /* recur to place rest of the queens */
                    solve(result, cur, n, row+1, column, diag1, diag2);

                    /* If placing queen in board[row][col]
                   doesn't lead to a solution then
                   remove queen from board[row][col] */
                    column[col]= diag1[id1]= diag2[id2]=false; // backtrack
                    cur.remove(cur.size()-1); // remove last one
                }
            }
        }


        public static void main(String[] args) {

            solveNQueens(4);

        }

}

/*----------------------------------------------------------------------------------- 
 Problem: 
