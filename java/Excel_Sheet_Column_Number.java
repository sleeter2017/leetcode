// https://leetcode.com//problems/excel-sheet-column-number/#/description		 QuestionId:171
import java.io.*; 
import java.util.*; 
// https://leetcode.com/problems/excel-sheet-column-number/#/description
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (char ch: s.toCharArray())
            result = result * 26 + (ch - 'A' + 1);
            
        return result;
    }
}

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Related to question Excel Sheet Column Title
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -&gt; 1
    B -&gt; 2
    C -&gt; 3
    ...
    Z -&gt; 26
    AA -&gt; 27
    AB -&gt; 28 

Credits:Special thanks to @ts for adding this problem and creating all test cases.*/