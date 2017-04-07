// https://leetcode.com//problems/factor-combinations/#/description		 QuestionId:254
import java.io.*; 
import java.util.*; 
// https://leetcode.com/problems/factor-combinations/#/solutions
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, 2);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int n , int start) {
        
        if(n <= 1) {
            if(tempList.size() > 1) res.add(new ArrayList<Integer>(tempList));
            return;
        } else {
            
            for(int i = start; i <= n; i++) {
                if( n % i == 0 ) {
                    tempList.add(i);
                    backtrack(res, tempList, n/i, i);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}

/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/