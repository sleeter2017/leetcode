// https://leetcode.com//problems/minimum-size-subarray-sum/#/description		 QuestionId:209
import java.io.*; 
import java.util.*; 
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
            int sum = 0, from = 0, win = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (sum >= s) {
                    win = Math.min(win, i - from + 1);
                    sum -= nums[from++];
                }
            }
            return (win == Integer.MAX_VALUE) ? 0 : win;
        }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
