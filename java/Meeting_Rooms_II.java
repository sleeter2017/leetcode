// https://leetcode.com//problems/meeting-rooms-ii/#/description		 QuestionId:253
import java.io.*; 
import java.util.*; 
/**
 * https://discuss.leetcode.com/topic/35253/explanation-of-super-easy-java-solution-beats-98-8-from-pinkfloyda
 * 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 2) return intervals.length;
        
        int [] start = new int[intervals.length];
        int [] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 1;
        int j = 0;
        for(int i=1; i < start.length; i++) {
            if(start[i] >= end[j] ) { //same room can accomodate
                j++;
            } else {
                //there is overlapping, need another room
                rooms++;
            }
        }
        return rooms;
    }
    
        
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/