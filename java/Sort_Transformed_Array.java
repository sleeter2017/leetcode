// https://leetcode.com//problems/sort-transformed-array/#/description		 QuestionId:360
import java.io.*; 
import java.util.*; 
/*
the problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0). However, they can be combined into just 2 cases: a>0 or a<0

1.a>0, two ends in original array are bigger than center if you learned middle school math before.

2.a<0, center is bigger than two ends.

so use two pointers i, j and do a merge-sort like process. depending on sign of a, you may want to start from the beginning or end of the transformed array. For a==0 case, it does not matter what b's sign is.
The function is monotonically increasing or decreasing. you can start with either beginning or end.
*/
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int start = 0, end = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (start <= end) {
            int startQuad = quad(nums[start],a,b,c);
            int endQuad = quad(nums[end],a,b,c);
            if (a >= 0) {
                 if(startQuad >= endQuad) {
                     sorted[index--] = startQuad;
                     start++;
                 } else {
                     sorted[index--] = endQuad;
                     end--;
                 }
                
            } else {

                 if(startQuad >= endQuad) {
                     sorted[index++] = endQuad;
                     end--;
                 } else {
                     sorted[index++] = startQuad;
                     start++;
                 }
            }
        }
        return sorted;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/