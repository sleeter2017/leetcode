// https://leetcode.com//problems/expression-add-operators/#/description		 QuestionId:282
import java.io.*; 
import java.util.*; 
// https://leetcode.com//problems/expression-add-operators/		 QuestionId:282
/*
This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

Time Complexity:
T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
Thus T(n) = 4T(n-1);

the time complexity is O(4^n)
*/
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
       	StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
        
    }
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
    	if(pos == num.length() && (target == prev)) {
    	    res.add(sb.toString());
    		return;
    	}
    	
    	for(int i = pos; i < num.length(); i++) {
    		if(num.charAt(pos) == '0' && i != pos) break; // leading multiple zeros
    		long curr = Long.parseLong(num.substring(pos, i + 1));
    		int len = sb.length();
    		if(pos == 0) {
    			dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
    			sb.setLength(len);
    		} else {
    			dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
    			sb.setLength(len);
    			dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
    			sb.setLength(len);
    			dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
    			//if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right?
    			// If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied,
    			// so you want to take it out from the existing eval. You have 1 + 2 + 3 * 4
    			// and the eval now is (1 + 2 + 3) - 3 + (3 * 4).
    			sb.setLength(len); //backtrack
    		}
    	}
    }
}

/*
Withour StringBuilder:
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}


Problem:
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.


Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []


Credits:Special thanks to @davidtan1890 for adding this problem and creating all test cases.*/