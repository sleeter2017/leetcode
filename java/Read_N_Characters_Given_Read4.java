// https://leetcode.com//problems/read-n-characters-given-read4/#/description		 QuestionId:157
import java.io.*; 
import java.util.*; 
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char []tbuf = new char[4];
        int i=0;
        for(; i < n;) {
            int count = read4(tbuf);
            if(count == 0) break; // eof, so end reading
            for(int j=0; j < count && i < n; j++,i++)
                buf[i] = tbuf[j];
        }
        return i;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/

/*

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.
 */