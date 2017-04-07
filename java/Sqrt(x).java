// https://leetcode.com//problems/sqrtx/#/description		 QuestionId:69
import java.io.*; 
import java.util.*; 
public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = (left + right)/2;
            if (mid > x/mid) {  // (mid * mid > x)  causes overflow
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1)) // mid^2 < x && (mid+1)^2 > x
                    return mid;
                left = mid + 1;
            }
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Implement int sqrt(int x).

Compute and return the square root of x.*/