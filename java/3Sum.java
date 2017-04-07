// https://leetcode.com//problems/3sum/#/description		 QuestionId:15
import java.io.*; 
import java.util.*; 
/*
The idea is to sort an input array and then run through all indices of a possible first element of a triplet. For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
*/
public class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue; // avoid duplicates
            
            int low = i+1, high = nums.length-1;
            while(low<high) {
                int sum = nums[i]+nums[low]+nums[high];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                    while(low<high && nums[low] == nums[low-1]) low++; // avoid duplicates
                    while(low<high && nums[high] == nums[high+1]) high--; //avoid duplicates
                }
                else if(sum > 0)  high--;
                else low++;
            }
        }
        return res;
    }
}

/*
Problem:
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.


For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/