// https://leetcode.com//problems/read-n-characters-given-read4-ii-call-multiple-times/#/description		 QuestionId:158
import java.io.*; 
import java.util.*; 
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//https://discuss.leetcode.com/topic/7094/a-simple-java-code
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
        private int buffPtr = 0;
        private int buffCnt = 0;
        private char[] buff = new char[4];
        public int read(char[] buf, int n) {
            int ptr = 0;
            while (ptr < n) {
                if (buffPtr == 0) {
                    buffCnt = read4(buff);
                }
                if (buffCnt == 0) break;
                while (ptr < n && buffPtr < buffCnt) {
                    buf[ptr++] = buff[buffPtr++];
                }
                if (buffPtr >= buffCnt) buffPtr = 0;
            }
            return ptr;
        }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/