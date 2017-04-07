// https://leetcode.com//problems/count-primes/#/description		 QuestionId:204
import java.io.*; 
import java.util.*; 
    public class Solution {
        public int countPrimes(int n) {
            if (n < 3)
                return 0;

            boolean[] prime = new boolean[n];
            int count = n / 2;
            for (int i = 3; i * i < n; i += 2) { //consider only odd numbers as even numbers cant be primes
                if (prime[i])
                    continue;

                for (int j = i * i; j < n; j += 2 * i) {
                    if (!prime[j]) {
                        --count;
                        prime[j] = true; //its prime number
                    }
                }
            }
            return count;
        }
    }

/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
