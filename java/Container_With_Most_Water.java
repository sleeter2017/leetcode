// https://leetcode.com//problems/container-with-most-water/#/description		 QuestionId:11
import java.io.*; 
import java.util.*; 
/*
Start by evaluating the widest container, using the first and the last line. All other possible containers are less wide, so to hold more water, they need to be higher. Thus, after evaluating that widest container, skip lines at both ends that don't support a higher height. Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
https://discuss.leetcode.com/topic/16754/simple-and-fast-c-c-with-explanation
*/
public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2) return 0;
        
        int l = 0, r = height.length-1;
        int water = 0;
        
        while(l < r) {
            int h = Math.min(height[l], height[r]);
            water = Math.max(water, h*(r-l));
            
            // skip the ones which are less height than current max height
            while(height[l] <= h && (l<r)) l++; 
            while(height[r] <=h && (l<r)) r--;
        }
        return water;
    }
}

/*
Problem:
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/