// https://leetcode.com//problems/palindrome-number/#/description		 QuestionId:9
import java.io.*; 
import java.util.*; 
/*
It turns out that comparing from the two ends is easier. First, compare the first and last digit. If they are not the same, it must not be a palindrome. If they are the same, chop off one digit from both ends and continue until you have no digits left, which you conclude that it must be a palindrome.
*/
public class Solution {
    /*
    public int reverse(int x) {
        if(x<0) {
            return 0;
        }   
        int rev = 0;
        while(x > 0) {
            if((rev*10)/10 != rev) {
                return 0; // overflow
            }
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev;
    }
    public boolean isPalindrome(int x) {
        return (reverse(x) == x);
        
    }
    */
    public boolean isPalindrome(int x) {
      if (x < 0) return false;
      int div = 1;
      //find number of zeros
      while (x / div >= 10) {
        div *= 10;
      }        
      while (x != 0) {
        int l = x / div;
        int r = x % 10;
        if (l != r) return false;
        x = (x % div) / 10;
        div /= 100;
      }
      return true;
    }
}

/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

/*----------------------------------------------------------------------------------- 
 Problem: 
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

*/