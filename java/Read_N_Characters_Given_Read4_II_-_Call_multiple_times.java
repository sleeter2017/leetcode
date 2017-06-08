// https://leetcode.com//problems/read-n-characters-given-read4-ii-call-multiple-times/#/description		 QuestionId:158

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//https://discuss.leetcode.com/topic/7094/a-simple-java-code
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
        private int destBufferPtr = 0;
        private int sourceBufferCnt = 0;
        private char[] sourceBuffer = new char[4];


        public int read(char[] destBuffer, int n) {
            int ptr = 0;
            while (ptr < n) {
                if (destBufferPtr == 0) {
                    sourceBufferCnt = read4(sourceBuffer);
                }
                if (sourceBufferCnt == 0) break;  // eof
                while (ptr < n && destBufferPtr < sourceBufferCnt) {
                    destBuffer[ptr++] = sourceBuffer[destBufferPtr++];
                }
                if (destBufferPtr >= sourceBufferCnt) destBufferPtr = 0;
            }
            return ptr;
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
The read function may be called multiple times.
 */


/*
This question is before that Road Read N Characters Given Read4 expansion , that question that read function can only call once, and this question says read function
can be called many times, then the difficulty is increased , in order to more simple and intuitive description Problem, we give a simple example, for example:

Buf = "ab", [read (1), read (2)], return ["a", "b"

Then the first call read (1) , read from buf a character, then the first character a, and then call a read (2) , would like to take out two characters, but buf only one b ,
So the result is taken out b. Let's look at an example:

Buf = "a", [read (0), read (1), read (2)] , return ["", "a", ""

The first call to read (0) , do not take any characters, return empty, the second call read (1), take a character, buf only one character, remove a, and then call read (2),
want to take out Two characters, but buf no characters, so take out empty.

But this question I do not understand the place is a clear function of the return type is int, ah, why OJ output are vector <char> category, and then
I found the following two online through the OJ solution, Probably looked at, but also to see a little knowledge, seemingly with two variables readPos
and writePos to record the location of read and write, i from 0 to n to start the cycle, if the time to read and write the same, then we call Read4 function,
the results assigned to writePos, readPos set to zero, if writePos is zero, then there is nothing in buf, and return to the current coordinates i.
Then we use the built-in buff variable readPos position to override the input string buf i position, if completed traversal, return n, see the code as follows:
 */