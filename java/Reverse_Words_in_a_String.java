// https://leetcode.com//problems/reverse-words-in-a-string/#/description		 QuestionId:151
import java.io.*; 
import java.util.*; 
public class Solution {
    public String reverseWords(String s) {
        
        StringBuffer reversed = new StringBuffer();
        String[] words = s.trim().split("\\s+"); // split based on multiple spaces

        for(int i = words.length-1; i >0 ; i--)
            reversed.append(words[i]).append(" ");
        
        reversed.append(words[0]);
        
        return reversed.toString();
    }
}

/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an input string, reverse the string word by word.



For example,
Given s = "the sky is blue",
return "blue is sky the".



Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.


click to show clarification.

Clarification:



What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.


*/