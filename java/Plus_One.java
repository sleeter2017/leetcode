// https://leetcode.com//problems/plus-one/#/description		 QuestionId:66
import java.io.*; 
import java.util.*; 
public class Solution {
    public int[] plusOne(int[] digits) {
        
        int size = digits.length+1;
        for(int digit: digits)
            if(digit < 9) {
                size--;
                break;
            }
        
        int []res = new int[size];
        int carry=1;
        for(int i=digits.length-1; i >=0; i--) {
            res[i] = (digits[i] + carry ) % 10;
            carry = (digits[i] + carry )/10;
        }
        if(size > digits.length) res[0]=1;
        
        return res;
    }
}

/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.*/