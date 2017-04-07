// https://leetcode.com//problems/flip-game/#/description		 QuestionId:293
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List list = new ArrayList();
        int i = -1;
        while( (i = s.indexOf("++", i+1)) >= 0)
            list.add(s.substring(0, i) + "--" + s.substring(i+2));
        return list;
    }
}

/*
Problem:
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
*/

/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/