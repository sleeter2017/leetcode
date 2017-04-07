// https://leetcode.com//problems/permutations/#/description		 QuestionId:46
import java.io.*; 
import java.util.*; 
public class Solution {
        public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 ) return res;
        
        //Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue; // skip duplicates
            used[i]=true;
            temp.add(nums[i]);
            backtrack(res, temp, nums, used);
            temp.remove(temp.size()-1); // backtrack
            used[i]=false; // backtrack
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a collection of distinct numbers, return all possible permutations.



For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/