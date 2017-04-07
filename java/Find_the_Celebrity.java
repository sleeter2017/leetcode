// https://leetcode.com//problems/find-the-celebrity/#/description		 QuestionId:277
import java.io.*; 
import java.util.*; 
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//https://discuss.leetcode.com/topic/23534/java-solution-two-pass      

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/