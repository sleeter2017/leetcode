// https://leetcode.com//problems/combination-sum-iii/#/description		 QuestionId:216
import java.io.*; 
import java.util.*; 
public class Solution {

 public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int maxsize,  int start, int remain) {
    	if (comb.size() == maxsize && remain == 0) {
    		ans.add(new ArrayList<Integer>(comb));
    		return;
    	}
    	for (int i = start; i <= 9; i++) {
    	    if(comb.size() < maxsize) {
        		comb.add(i);
        		combination(ans, comb, maxsize, i+1, remain-i);
        		comb.remove(comb.size() - 1); //backtrack
    	    }
    	}
    }
}

/*
Problem:
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.



 Example 1:
Input:  k = 3,  n = 7
Output: 

[[1,2,4]]


 Example 2:
Input:  k = 3,  n = 9
Output: 

[[1,2,6], [1,3,5], [2,3,4]]



Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.*/