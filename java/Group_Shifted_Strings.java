// https://leetcode.com//problems/group-shifted-strings/#/description		 QuestionId:249
import java.io.*; 
import java.util.*; 
//https://discuss.leetcode.com/topic/29725/concise-10-lines-java-solution-with-explanation
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        Arrays.sort(strings);
        StringBuffer key = new StringBuffer();
        for(String word:strings) {
            key.setLength(0);
            for(int i = 1; i < word.length(); i++) {
                key.append((word.charAt(i) - word.charAt(i-1) + 26) % 26);;//this is nice trick of adding 26 and taking % 26 to consider the circular shifting pattern from z to a
            }
            map.putIfAbsent(key.toString(), new ArrayList<String>());
            map.get(key.toString()).add(word);
        }
        
        return new ArrayList<List<String>>(map.values());
        
    }
}

/*
Problem:
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

Solution:
The basic idea is to set a key for each group: the sum of the difference between the adjacent chars in one string.
Then we can easily group the strings belonging to the same shifting sequence with the same key. The code is as the following:
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/