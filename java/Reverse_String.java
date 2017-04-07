// https://leetcode.com//problems/reverse-string/#/description		 QuestionId:344
import java.io.*; 
import java.util.*; 
public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        
        for(int i=0, j=arr.length-1; i < j; i++,j--){
            char tmp = arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
        return new String(arr);
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Write a function that takes a string as input and returns the string reversed.


Example:
Given s = "hello", return "olleh".
*/