// Explanation: https://www.youtube.com/watch?v=l3hda49XcDE
//http://articles.leetcode.com/regular-expression-matching/
// Related: https://leetcode.com/problems/wildcard-matching/

/*
wildcard matching:
------------------
1) If p[j] == ? || p[j]==s[i]:
        dp[i][j] = dp[i-1][j-1]   // take diagonal value
2) If p[j] == *
       dp[i][j] = dp[i][j-1] || dp[i-1][j]  //left or up
                = else false

Initialize 0th row:
  if p[j] == '*', dp[0][p] = dp[0][p-1]   // take left

Final result will be at: dp[s.length()][p.length()]

Regular matching:
------------------
    1) If p[j] == '.' || p[j] == s[i] :  dp[i][j] = dp[i-1][j-1]; //diagonal cell
    2) If p[j] == '*':
       here are two sub conditions:
                   1   if p[j-1] != s.charAt[i] : dp[i][j] = dp[i][j-2]  //2 left, in this case, a* only counts as empty
                   2   if p[i-1] == s.charAt[i] or p.charAt[i-1] == '.':
                                  dp[i][j] = dp[i-1][j]   //left, in this case, a* counts as multiple a
                               or dp[i][j] = dp[i][j-1]   //up, in this case, a* counts as single a
                               or dp[i][j] = dp[i][j-2]   //2 left, in this case, a* counts as empty
Initialize 0th row:
  if p[j] == '*', dp[0][p] = dp[0][p-2]   // take 2 left

  Final result will be at: dp[s.length()][p.length()]

*/
public class Solution {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int col = 0; col < p.length(); col++) {
            if(p.charAt(col) == '*')
                dp[0][col+1] = dp[0][col-1]; // 2 left
            // all leading '*' should be true. This will throw Line ArrayIndexOutOfBoundsException: -1  if p starts with *
        }

        for (int row = 0 ; row < s.length(); row++) {
            for (int col = 0; col < p.length(); col++) {
                if (p.charAt(col) == '.' || p.charAt(col) == s.charAt(row)) {
                    dp[row+1][col+1] = dp[row][col]; // diagonal cell
                }

                if (p.charAt(col) == '*') {
                    if (p.charAt(col-1) != s.charAt(row) && p.charAt(col-1) != '.') {
                        dp[row+1][col+1] = dp[row+1][col-1];//2 left: in this case, a* only counts as empty
                    } else {
                        dp[row+1][col+1] =
                                (dp[row+1][col] ||//left, a* counts as single a
                                        dp[row][col+1] || //up, a* counts as multiple a
                                        dp[row+1][col-1]);//2 left, a* counts as empty
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

/*
Problem:
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
