// https://leetcode.com//problems/sort-characters-by-frequency/#/description		 QuestionId:451
import java.io.*; 
import java.util.*; 
public class Solution {
    public String frequencySort(String s) {
        int []frequency = new int[256];

        for(char c: s.toCharArray())
            frequency[c]++;

        //1. Construct frequency map
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        char c = 0; c--;
        for(int freq: frequency){
            c++; // we always want to start at 0
            if(freq == 0 ) continue;
            map.putIfAbsent(freq, new StringBuilder());
            StringBuilder value = map.get(freq);
            for(int count = 0; count < freq; count++) value.append(c);

            //map.put(freq,value);
        }

        //2. Sort frequency and print characters in Desc order
        StringBuilder sb = new StringBuilder();
        Arrays.sort(frequency);
        int prev = 0;
        for(int freq: frequency) { // take only unique frequency as we have already repeated chars based on frequency
            if(freq > 0 && freq != prev) sb.append(map.get(freq));
            prev = freq;
        }
        return sb.reverse().toString();
    }    
}

/*
Another accepted solution, but its very slow:
    public String frequencySort(String s) {

        int[] frequency = new int[256];
        for(char ch: s.toCharArray())
            frequency[ch]++;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b)-> b.frequency-a.frequency);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < frequency.length; i++) {
            if(frequency[i]==0) continue;
            sb.setLength(0);
            for(int freq = 0; freq < frequency[i]; freq++) sb.append((char)i);
            pq.offer(new Tuple(frequency[i], sb.toString()));
        }
        sb.setLength(0);
        while(!pq.isEmpty())
            sb.append(pq.poll().value);

        return sb.toString();
    }

class Tuple {
    int frequency;
    String value;
    public Tuple(int freq, String val) {
        this.frequency = freq;
        this.value = val;
    }
  }
 */
 
 /*
 Problem:
 Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.



Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.



Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/