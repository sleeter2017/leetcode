// https://leetcode.com//problems/basic-calculator-ii/#/description		 QuestionId:227
import java.io.*; 
import java.util.*; 
public class Solution {
    public int calculate(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>(); // This holds all numbers to be added at the end
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || i==len-1){
                // as soon as we find sign or last character, process
                switch(sign) {
                case '-':
                    stack.push(-num);
                    break;
                case '+':
                    stack.push(num);
                    break;
                case '*':
                    stack.push(stack.pop()*num);
                    break;
                case '/':
                    stack.push(stack.pop()/num);
                    break;
                }
                sign = ch; // update sign to the current sign
                num = 0; // reset num as the previous one is processed above
            }
        }
    
        int res = 0;
        for(int number:stack){
            res += number;
        }
        return res;
    }
}

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

/*----------------------------------------------------------------------------------- 
 Problem: 
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5




Note: Do not use the eval built-in library function.


Credits:Special thanks to @ts for adding this problem and creating all test cases.*/