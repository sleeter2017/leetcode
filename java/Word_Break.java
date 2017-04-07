// https://leetcode.com//problems/word-break/#/description		 QuestionId:139
import java.io.*; 
import java.util.*; 
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<String>();
        
        for(String word: wordDict)
            set.add(word);
        
        boolean[] memo = new boolean[s.length()+1];
        
        memo[0] = true;
        
        for(int i = 1; i <= s.length(); i++)
            for(int j = 0; j < i; j++) {
                if(memo[j] && set.contains(s.substring(j,i))) {
                    memo[i] = true;
                    break;
                }
            }
        return memo[s.length()];
    }
}

/*
Problem:
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.


For example, given
s = "leetcode",
dict = ["leet", "code"].



Return true because "leetcode" can be segmented as "leet code".



UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/