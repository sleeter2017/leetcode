// https://leetcode.com//problems/maximum-product-of-word-lengths/#/description		 QuestionId:318
import java.io.*; 
import java.util.*; 
/*
int has 32bits,but lower case letters only has 26 .we can use the lowest 26 bit of int indicates that the word has how many kinds of lower case letters .If the lowest bit of int is 1,it indicates the word has lower case letter 'a'.......the order of lower case letter is from right to left,like zyx.....cba.so value[i] indicates the condition of the word i having how many kinds of lower case letters
*/
public class Solution {
    public int maxProduct(String[] words) {
        
        // Generate bit representation for each word
        int[] bits = new int[words.length];
        int i=0;
        for(String word: words) {
            int bit=0;
            for(int j=0; j<word.length();j++)
                bit |= 1 << (word.charAt(j) - 'a');
            bits[i++] = bit;
        }
        int maxProd = 0;
        for(i = 0; i < words.length; i++) {
            for(int j=i+1; j < words.length; j++) {
                if( (bits[i] & bits[j]) == 0) {
                    // all bits are unique
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}

/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

    Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
    You may assume that each word will contain only lower case letters.
    If no such two words exist, return 0.



    Example 1:


    Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
    Return 16
    The two words can be "abcw", "xtfn".


    Example 2:


    Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
    Return 4
    The two words can be "ab", "cd".


    Example 3:


    Given ["a", "aa", "aaa", "aaaa"]
    Return 0
    No such pair of words.    


Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.*/