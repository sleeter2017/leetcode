// https://leetcode.com//problems/add-digits/#/description		 QuestionId:258
import java.io.*; 
import java.util.*; 
//https://en.wikipedia.org/wiki/Digital_root
/* 3 cases 
  1) if number is 0, return 0
  2) if its multiple of 9, return 9
  3) else return num%9
*/
public class Solution {
    public int addDigits(int num) {
                return num==0?0:(num%9==0?9:(num%9));
    }
}

/*
num             | ans
---------------------
0               |  0
multiple of 9   |  9
else            | %9
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. 



For example:


Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.


Follow up:
Could you do it without any loop/recursion in O(1) runtime?



  A naive implementation of the above process is trivial. Could you come up with other methods? 
  What are all the possible results?
  How do they occur, periodically or randomly?
  You may find this Wikipedia article useful.


Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.*/