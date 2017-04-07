// https://leetcode.com//problems/excel-sheet-column-title/#/description		 QuestionId:168
import java.io.*; 
import java.util.*; 
//https://leetcode.com/problems/excel-sheet-column-title/#/description

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }

        return result.reverse().toString();
    }
}

/*
  1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.*/