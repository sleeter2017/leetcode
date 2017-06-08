// https://leetcode.com//problems/letter-combinations-of-a-phone-number/#/description		 QuestionId:17
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<String> letterCombinations(String digits) {

        String[] map =  {"0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<String>();
        if(digits.length() == 0) return res;
        
        res.add(""); // This is important
        for(int i=0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            String comb = map[digit];
            while(res.peek().length() == i) {
                String cur = res.remove();
                for(char c: comb.toCharArray())
                    res.add(cur+c);
            }
        }
        return res;
    }
}

/*
Problem:
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a digit string, return all possible letter combinations that the number could represent.



A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].



Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/