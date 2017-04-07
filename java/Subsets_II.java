// https://leetcode.com//problems/subsets-ii/#/description		 QuestionId:90
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(temp));
        
        for(int i = start; i < nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1); // backtrack
        }
    }
}

/*----------------------------------------------------------------------------------- 
 Problem: 

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.


For example,
If nums = [1,2,2], a solution is:



[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/