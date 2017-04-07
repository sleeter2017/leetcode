// https://leetcode.com//problems/generate-parentheses/#/description		 QuestionId:22
import java.io.*; 
import java.util.*; 
/*
The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these steps are recursively called.
*/
public class Solution {
 public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        backtrack(list, cur, 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, StringBuilder cur, int open, int close, int max){
        
        if(cur.length() == max*2){
            list.add(cur.toString());
            return;
        }
        int len = cur.length();
        if(open < max) {
            backtrack(list, cur.append('('), open+1, close, max);
            cur.setLength(len);
        }
        if(close < open) {
            backtrack(list, cur.append(')'), open, close+1, max);
            cur.setLength(len);
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



For example, given n = 3, a solution set is:


[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/