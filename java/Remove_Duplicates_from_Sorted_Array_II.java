// https://leetcode.com//problems/remove-duplicates-from-sorted-array-ii/#/description		 QuestionId:80
import java.io.*; 
import java.util.*; 
public class Solution {
    public int removeDuplicates(int[] nums) {
       int i = 2;
       for (int j = 2 ; j< nums.length; j++)
          if (nums[j] > nums[i - 2])
             nums[i++] = nums[j];
       return i;
    }
}

/*
Remove Duplicates from Sorted Array(no duplicates) :

    public int removeDuplicates(int[] nums) {
       int i = 1;
       for (int j = 1 ; j< nums.length; j++)
          if (nums[j] > nums[i - 1])
             nums[i++] = nums[j];
       return i;
    }
Remove Duplicates from Sorted Array II (allow duplicates up to 2):

public int removeDuplicates(int[] nums) {
   int i = 0;
   for (int n : nums)
      if (i < 2 || n > nums[i - 2])
         nums[i++] = n;
   return i;
}
*/

/*
Problem:
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?


For example,
Given sorted array nums = [1,1,1,2,2,3],


Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/