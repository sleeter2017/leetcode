// https://leetcode.com//problems/non-overlapping-intervals/#/description		 QuestionId:435
import java.io.*; 
import java.util.*; 
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 /* https://discuss.leetcode.com/topic/65594/java-least-is-most
 Actually, the problem is the same as "Given a collection of intervals, find the maximum number of intervals that are non-overlapping." (the classic Greedy problem: Interval Scheduling). With the solution to that problem, guess how do we get the minimum number of intervals to remove? : )

Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).

*/
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        
        if(intervals.length < 2) return 0;
        
        Arrays.sort(intervals, (a,b)->(a.end - b.end)); // sort based on increasing order of end time
        int nonOverlapCount = 1, end = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= end) {
                end = intervals[i].end;
                nonOverlapCount++;
            }
        }
        return intervals.length - nonOverlapCount;
    }
}

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.


Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.



Example 1:

Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.



Example 2:

Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.



Example 3:

Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/