// https://leetcode.com//problems/strobogrammatic-number-ii/#/description		 QuestionId:247
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        
        List<String> cur = null, res = null;
        if(n % 2 == 0) 
            res = new ArrayList<String>(Arrays.asList("")); // even
        else 
            res = new ArrayList<String>(Arrays.asList("0", "1", "8")); // odd
        
        if(n < 2) return res;
        
        for(; n > 1; n-=2) {
            cur = res;
            res = new ArrayList<String>();
            for(String str : cur) {
                if(n > 3) res.add('0' + str + '0'); // eg. 6009, 9006
                res.add('1' + str + '1');
                res.add('6' + str + '9');
                res.add('9' + str + '6');
                res.add('8' + str + '8');
            }
        }
        return res;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/