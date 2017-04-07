// https://leetcode.com//problems/add-binary/#/description		 QuestionId:67
import java.io.*; 
import java.util.*; 
public class Solution {
    public String addBinary(String a, String b) {
        
        StringBuffer sum = new StringBuffer();
        int ai = a.length() -1, bi = b.length() -1;
        int carry = 0, cursum = 0;
        while(ai >= 0 || bi >= 0 ) {
            cursum = carry;
            if(ai >= 0) cursum += a.charAt(ai--) - '0';
            if(bi >= 0) cursum += b.charAt(bi--) - '0';
            //store current sum
            sum.append(cursum % 2);
            carry = cursum / 2;
        }
        if(carry > 0) sum.append(carry);
        return sum.reverse().toString();
    }
}

/*
Problem:
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given two binary strings, return their sum (also a binary string).



For example,
a = "11"
b = "1"
Return "100".
*/