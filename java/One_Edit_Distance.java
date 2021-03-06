// https://leetcode.com//problems/one-edit-distance/#/description		 QuestionId:161
import java.io.*; 
import java.util.*; 
//https://discuss.leetcode.com/topic/30308/my-clear-java-solution-with-explanation
public class Solution {
/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
        	if (s.charAt(i) != t.charAt(i)) {
        		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
        			return s.substring(i + 1).equals(t.substring(i + 1));
    			else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
    				return s.substring(i).equals(t.substring(i + 1));	        	
    			else // s is longer than t, so the only possibility is deleting one char from s
    				return t.substring(i).equals(s.substring(i + 1));
        	}
        }       
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(s.length() - t.length()) == 1;        
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/