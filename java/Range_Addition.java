// https://leetcode.com//problems/range-addition/#/description		 QuestionId:370
import java.io.*; 
import java.util.*; 
/*
We update the value at start index, because it will be used in the future when we are adding up the values for the sum at each index between start index and end index (both inclusive). We update the negative value at the end index + 1, because the positive value of it should be only added at its previous indices (from start index to end index). Thus, when we accumulate the sum at the end for each index, we will get the correct values for each index. If the end index is the last index in the resulting array, we don't have to do the end index + 1 part, because there is no more index after the last index and there will be no error when we accumulate the sum
*/

public class Solution {
     public int[] getModifiedArray(int length, int[][] updates) {
    
        int[] res = new int[length];
         for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];
            
            res[start] += value;
            
            if(end < length - 1)
                res[end + 1] -= value;
            
        }
        
        for(int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        
        return res;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/