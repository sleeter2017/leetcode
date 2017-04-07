// https://leetcode.com//problems/two-sum/#/description		 QuestionId:1
import java.io.*; 
import java.util.*; 
public class Solution {
        public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            // find pair
            int second = target - nums[i];
            if(map.containsKey(second) && map.get(second) != i ) { // second should not be first\
                return new int[]{ map.get(second), i };
            }
            // create hash
            map.put(nums[i], i);
        }

        // no pair found
        return null;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.


Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/