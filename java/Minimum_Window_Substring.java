// https://leetcode.com//problems/minimum-window-substring/#/description		 QuestionId:76
import java.io.*; 
import java.util.*; 
// Explanation: http://articles.leetcode.com/finding-minimum-window-in-s-which/
public class Solution {
        public static String minWindow(String s, String t) {
            int[] needToFind = new int[256]; // Need to find
            int[] hasFound = new int[256]; // found so far

            //initalize map
            for(char ch:t.toCharArray())
                needToFind[ch]++;

            int start = 0, end = 0, minWindowStartsAt = 0, minlength = Integer.MAX_VALUE, counter = 0;

            for(; end < s.length(); end++) {
                char endch = s.charAt(end);

                if(needToFind[endch] == 0) continue; // a character which is not needed
                hasFound[endch]++;
                if(hasFound[endch] <= needToFind[endch]) counter++;


                if(counter == t.length()) { // found all characters
                    /*  skip all chars at 'start' when
                        1) it is not needed
                        2) it has excess than needed

                     */
                    char startch = s.charAt(start);

                    while(needToFind[startch] == 0  // char at 'start' not needed
                            || hasFound[startch] > needToFind[startch] ) { // it is in excess than needed
                            
                        if(hasFound[startch] > needToFind[startch]) hasFound[startch]--;

                        //move start to next
                        startch = s.charAt(++start);
                    }

                    // did we find new min window ?
                    if(end-start+1 < minlength) {
                        minlength = end - start + 1; //update with new window
                        minWindowStartsAt = start;
                    }
                }
            }
            return minlength == Integer.MAX_VALUE ? "" : s.substring(minWindowStartsAt, minWindowStartsAt+minlength);
        }
}

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).



For example,
S = "ADOBECODEBANC"
T = "ABC"


Minimum window is "BANC".



Note:
If there is no such window in S that covers all characters in T, return the empty string "".


If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/