// https://leetcode.com//problems/subsets/#/description		 QuestionId:78
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(temp));
        
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1); // backtrack
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.


For example,
If nums = [1,2,3], a solution is:



[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/