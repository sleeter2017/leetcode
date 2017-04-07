// https://leetcode.com//problems/longest-substring-without-repeating-characters/#/description		 QuestionId:3
import java.io.*; 
import java.util.*; 
/*
Solution: Starting from each character, find the length of substring with all unique characters.
          Each time, update the maxLength. Its a straight forward algorithm with time complexity of O(n2)
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();

        boolean[] map=new boolean[256];
        int maxLength=1;
        for(int start = 0; start < s.length()-1; start++) {
            //find the first repeating character
            Arrays.fill(map,false);
            int end = start;
            for(; end < s.length(); end++) {
                if(map[s.charAt(end)]) //already exists
                    break;
                else
                    map[s.charAt(end)] = true;
            }
            maxLength = Math.max(maxLength, (end-start));
        }
        return maxLength;
    }
}

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/