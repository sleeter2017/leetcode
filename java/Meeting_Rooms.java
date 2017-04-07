// https://leetcode.com//problems/meeting-rooms/#/description		 QuestionId:252
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
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
                
        Arrays.sort(intervals, new myComparator());
        
        for(int i=1; i < intervals.length; i++)
            if(intervals[i-1].end > intervals[i].start)
                return false;
                
        return true;
    }
    
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/