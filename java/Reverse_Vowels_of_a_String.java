// https://leetcode.com//problems/reverse-vowels-of-a-string/#/description		 QuestionId:345
import java.io.*; 
import java.util.*; 
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        char[] arr = s.toCharArray();
        
        for(int start=0, end=arr.length-1; start <= end; start++, end--) {
            
            while(!vowels.contains(arr[start]) && start < end) start++;
            while(!vowels.contains(arr[end]) && start < end) end--;
            
            //swap
            if(vowels.contains(arr[start]) && vowels.contains(arr[end])) {
                char tmp = arr[end];
                arr[end] = arr[start];
                arr[start] = tmp;
            }
        }
        return new String(arr);
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Write a function that takes a string as input and reverse only the vowels of a string.


Example 1:
Given s = "hello", return "holle".



Example 2:
Given s = "leetcode", return "leotcede".



Note:
The vowels does not include the letter "y".
*/