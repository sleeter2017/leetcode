// https://leetcode.com//problems/anagrams/#/description		 QuestionId:49
import java.io.*; 
import java.util.*; 

public class Solution {
    private static final int WORDSIZE = 26;

    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, ArrayList<String>> encode = new HashMap<String, ArrayList<String>>();

        StringBuilder hashsb = new StringBuilder();
        for(String word: words) {
            hashsb.setLength(0);
            String hash = getHash(hashsb, word);
            encode.putIfAbsent(hash, new ArrayList<String>());
            encode.get(hash).add(word);
        }

        // Now return list of all values of encode
        return new ArrayList<List<String>>(encode.values()); //ArrayList<ArrayList<String>> fails
    }

    public static String getHash(StringBuilder hashsb, String word) {
        // assume word is only lower alphabets
        char[] hash = new char[WORDSIZE];
        for(char ch: word.toCharArray()) {
            hash[ch - 'a']++;
        }
         hashsb.append(hash);
        return hashsb.toString();

    }
}


/* Another accepted solution: */
/*
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
*/

/*----------------------------------------------------------------------------------- 
 Problem: 
Given an array of strings, group anagrams together.


For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.*/