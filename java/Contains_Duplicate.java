// https://leetcode.com//problems/contains-duplicate/#/description		 QuestionId:217
import java.io.*; 
import java.util.*; 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) 
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}

/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/