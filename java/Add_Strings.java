// https://leetcode.com//problems/add-strings/#/description		 QuestionId:415
import java.io.*; 
import java.util.*; 
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer sum = new StringBuffer();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        
        int l1 = n1.length-1, l2 = n2.length-1;
        
        int carry = 0;
        while(l1 >=0 || l2 >= 0) {
            if(l1 >=0) carry += n1[l1--]-'0';
            if(l2 >=0) carry += n2[l2--]-'0';
            //sum.append((char)(carry%10 + '0')); // This works too
            sum.append(carry%10);
            carry /= 10;
        }
        //if(carry > 0) sum.append((char)(carry + '0')); // This works too
        if(carry > 0) sum.append(carry);
        
        return sum.reverse().toString();
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/