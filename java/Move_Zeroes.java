// https://leetcode.com//problems/move-zeroes/#/description		 QuestionId:283
import java.io.*; 
import java.util.*; 
public class Solution {
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        
    
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        
    
        for (;insertPos < nums.length; insertPos++) {
            nums[insertPos] = 0;
        }
    }
}

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

/*
// https://leetcode.com//problems/moving-average-from-data-stream/		 QuestionId:346
//The idea is to keep the sum so far and update the sum just by replacing the oldest number with the new entry.


public class MovingAverage {

    private int [] window;
    private int n, insert;
    private long sum;
    
    // Initialize your data structure here. 
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert]; // remove oldest element
        sum += val;            // add current element
        window[insert] = val;  // store current element at oldest position
        insert = (insert + 1) % window.length; // update oldest position
        
        return (double)sum / n;
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

 
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.



For example, given nums  = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].



Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.



Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.*/