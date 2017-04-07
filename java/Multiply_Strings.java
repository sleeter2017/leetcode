// https://leetcode.com//problems/multiply-strings/#/description		 QuestionId:43
import java.io.*; 
import java.util.*; 
public class Solution {
    public String multiply(String num1, String num2) {
        StringBuffer cur = new StringBuffer();
        StringBuffer sum = new StringBuffer();

        int carry = 0;
        for(int i = num1.length()-1, izero = 0; i >=0; i--, izero++) {
            carry = 0;
            cur.setLength(0);
            for(int k=0; k<izero; k++) cur.append(0); // shifting new product for current line
            for(int j=num2.length()-1; j >=0; j--) {
                int mul = (num1.charAt(i) - '0')  *  (num2.charAt(j) - '0');

                int newsum = mul + carry;
                carry = newsum/10;
                cur.append(newsum % 10);
            }
            if(carry >0) cur.append(carry);

            // Add current sum to total sum
            carry = 0;
            for(int k=0; k<cur.length();k++) {
                carry += cur.charAt(k) - '0';
                if(sum.length() > k) {
                    carry += (sum.charAt(k) - '0');
                    sum.setCharAt(k, (char) (carry % 10 + '0'));
                } else {
                    sum.append(carry%10);
                }
                carry/=10;
            }
            if(carry>0) sum.append(carry);
        }
        //edge case:
        boolean allzero = true;
        for(int i = 0; i<sum.length(); i++) {
            if(sum.charAt(i) != '0')  allzero = false;
        }
        if(allzero) sum.setLength(1);
        return sum.reverse().toString();
    }
}

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/