// https://leetcode.com//problems/reverse-bits/#/description		 QuestionId:190
import java.io.*; 
import java.util.*; 
/*
The XOR swap trick:
Reversing bits could be done by swapping the n/2 least significant bits with its most significant bits. The trick is to implement a function called swapBits(i, j), which swaps the ith bit with the jth bit. If you still remember how XOR operation works: 0 ^ 0 == 0, 1 ^ 1 == 0, 0 ^ 1 == 1, and 1 ^ 0 == 1.

We only need to perform the swap when the ith bit and the jth bit are different. To test if two bits are different, we could use the XOR operation. Then, we need to toggle both ith and jth bits. We could apply the XOR operation again. By XOR-ing the ith and jth bit with 1, both bits are toggled.
*/


public class Solution {
    // you need treat n as an unsigned value
    
    /*
    public int reversed(int n, int i, int j) {
        int bit1 = (n >> i) & 1;
        int bit2 = (n >> j) & 1;
        if((bit1 ^ bit2) == 1) { //swap 2 bits only if they are different
            n ^= ((1 << i) | (1 <<j));
        }
        return n;
    }
    
    public int reverseBits(int n) {
        int bits = 32;
        int low = 0, high = bits-1;
        
        while(low < high) {
            n = reversed(n,low,high);
            low++;
            high--;
        }
        return n;    
    }
    */
/*
The following is a different trick. Consider it as circular list. 
*/
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1; // set last bit only if its set in original
            n >>= 1;
        }
        return result;
    }
}

/*
Problem:
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).


Follow up:
If this function is called many times, how would you optimize it?


Related problem: Reverse Integer

Credits:Special thanks to @ts for adding this problem and creating all test cases.*/