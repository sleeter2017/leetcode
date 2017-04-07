// https://leetcode.com//problems/longest-repeating-character-replacement/#/description		 QuestionId:424
import java.io.*; 
import java.util.*; 
/*
https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation/2

There's no edge case for this question. The initial step is to extend the window to its limit, that is, the longest we can get to with maximum number of modifications. Until then the variable start will remain at 0.

Then as end increase, the whole substring from 0 to end will violate the rule, so we need to update start accordingly (slide the window). We move start to the right until the whole string satisfy the constraint again. Then each time we reach such situation, we update our max length.
*/
public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCountOfASingleCharacterWithinThisWindow = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCountOfASingleCharacterWithinThisWindow = Math.max(maxCountOfASingleCharacterWithinThisWindow, ++count[s.charAt(end) - 'A']);
            int currentWindowSize = end - start + 1;
            while (currentWindowSize > k + maxCountOfASingleCharacterWithinThisWindow) {
                count[s.charAt(start) - 'A']--; // reduce the 'start' count as its not in the window
                start++; // as current window violated the condition, move start
				currentWindowSize--; 
            }
            maxLength = Math.max(maxLength, currentWindowSize);
        }
        return maxLength;
    }
}

/*
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.



Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.




Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/