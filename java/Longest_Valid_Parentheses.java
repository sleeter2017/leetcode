// https://leetcode.com//problems/longest-valid-parentheses/#/description		 QuestionId:32
import java.io.*; 
import java.util.*; 
public class Solution {
public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<Integer>(); //positions of '('
    int maxLen = 0; //longest valid parentheses
    
    for (int i = 0; i < s.length(); ++i) { // for every character in s
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else { //it's ')'
            if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop(); //encountered a valid '()'
                
                int lastPos = -1;
                if (!stack.empty())
                    lastPos = stack.peek();
                
                int curLen = i - lastPos;
                
                maxLen = Math.max(maxLen, curLen);
            } else
                stack.push(i); // will push ')' only when stack is empty or top is not '('
        }
    }
    return maxLen;
}}

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.


For "(()", the longest valid parentheses substring is "()", which has length = 2.


Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/