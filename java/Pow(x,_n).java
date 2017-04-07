// https://leetcode.com//problems/powx-n/#/description		 QuestionId:50
import java.io.*; 
import java.util.*; 
public class Solution {
    
    public double myPow(double x, int n) {
        HashMap<Integer, Double> memo = new HashMap<>();
        //pre store basic values, so that code is cleaner to write
        memo.put(0, 1.0);
        memo.put(1, x);
        memo.put(-1, 1.0/x);
        return helper(x,n,memo);
    }

        public double helper(double x, int n, HashMap<Integer, Double> memo) {
            if(memo.containsKey(n)) return memo.get(n);
            
            double half = helper(x, n / 2, memo);
            memo.put(n/2, half);
                
            if(n % 2 == 0) { //even number
                return half * half;
            } else { // odd number
                if(n<0) return half * half * 1.0 / x;
                else return half * half * x;
            }
        }
}

/*
Implement pow(x, n).
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Implement pow(x, n).
*/