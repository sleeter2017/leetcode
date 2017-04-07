// https://leetcode.com//problems/permutations-ii/#/description		 QuestionId:47
import java.io.*; 
import java.util.*; 
public class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
        }
        
        for(int i = 0; i < nums.length; i++) {
            // if used[i-1] is to make sure the order of same value does not change, so of [1,1,2]. the second 1 cannot be used if the first has not been used yet, which means when(!used[i-1]) we skip the second 1.
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]) ) continue; // skip duplicates
            used[i] = true;
            temp.add(nums[i]);
            backtrack(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1); // backtrack
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a collection of numbers that might contain duplicates, return all possible unique permutations.



For example,
[1,1,2] have the following unique permutations:

[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/