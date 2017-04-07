// https://leetcode.com//problems/minimum-number-of-arrows-to-burst-balloons/#/description		 QuestionId:452
import java.io.*; 
import java.util.*; 
/*
The idea is quite similar to Meeting Room II, where we need to greedily add new arrow (room) to current interval.
*/

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1) return 0;
        Arrays.sort(points, (a, b)->(a[0]-b[0]));
        int result = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            // check if current point starts after or before "end"
            if(points[i][0] > end) {
                //it starts after "end", so we need another arrow
                result ++;
                end = points[i][1];
            } else {
                // it starts before "end", so the same arrow can burst it, but we need to adjust new "end"
                end = Math.min(end, points[i][1]);
            }
        }
        return result;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart &le; x &le; xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons. 

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

*/