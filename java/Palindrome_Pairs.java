// https://leetcode.com//problems/palindrome-pairs/#/description		 QuestionId:336
import java.io.*; 
import java.util.*; 
public class Solution {

    // Trick: https://discuss.leetcode.com/topic/40654/easy-to-understand-ac-c-solution-o-n-k-2-using-map/7
    // Algorithm:
    // 1. Iterate thru all the words, reverse them and store pair<word, inded> in unordered_map for faster lookup to determie
    //    if the reverse of that string exists in the dict.
    // 2. Now, iterate thru words one by one.
    // 3. for each word: keep dividing them into left and right substring and check:
    //      1) if left part exists in the dict and right part is palindrome: then add pair{i, dict[left]} to result.
    //      2) if right part exists in the dict and left part is palindrome: then add pair{dict[right],i} to result.
   
    // Time: O(n*k^2)
    // In the main logic, the outer loop is O(n) since it's iterating through all the words in array.
    // In the inner loop, split into left part and right part have k possibilities, let k be the average length of words,
    // then when you use isPalindrome function for each combination, it's also k time in average,
    // so in total it's n * (k * k) hope this makes sense
    
  public List<List<Integer>> palindromePairs(String[] words) {
      Map<String, Integer> dict = new HashMap<>();
      List<List<Integer>> res = new ArrayList<>();
      // first reverse the words for faster lookup and store index as value.
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < words.length; i++) {
          sb.setLength(0);
          sb.append(words[i]);
          dict.put(sb.reverse().toString(), i);
      }
      
      for(int i = 0; i < words.length; i++) {
          String word = words[i];
          for(int j= 0; j < word.length(); j++) {
               // Divide string into left and right part
               String left = word.substring(0, j);
               String right = word.substring(j);
               
                // Check if left part is present in dict and its not the same(left being palindrome) by checking its index
                // and right is palindrome then it forms palidrome paris
                if(dict.containsKey(left) && dict.get(left) != i && isPalindrome(right)) {
                    res.add(new ArrayList(Arrays.asList(i, dict.get(left))));  // i, dict.get(left) are new palindrome pairs
                    
                    // What's more, here is a little improvement for the edge case: when there exists empty string,
                     // instead of using a separate loop for traversal, we can handle it in the "magic" part.
                     // When left is empty and right is a palindrome, apart from {i, dict[left]}, we can also add {dict[left],
                     // i} to result so that no valid pair is missing.
                     if(left.isEmpty()) res.add(new ArrayList(Arrays.asList(dict.get(left), i)));
                }
            
                // Same here for right part
                
                if(dict.containsKey(right) && dict.get(right) != i && isPalindrome(left)) {
                    res.add(new ArrayList(Arrays.asList(dict.get(right), i)));  // dict.get(right), i are new palindrome pairs
    
          }
      }
      }
      
      return res;
  }

        private boolean isPalindrome(String word) {
            int i = 0, j = word.length()-1;
            while (i < j) {
            	if (word.charAt(i++) != word.charAt(j--)) return false;
            }	
            return true;
        }

  }  
    

/*
    class TrieNode {
    TrieNode[] next;
    int index;
    List<Integer> list;
    	
    TrieNode() {
    	next = new TrieNode[26];
    	index = -1;
    	list = new ArrayList<>();
    }
}
    
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();

    TrieNode root = new TrieNode();
    for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
    for (int i = 0; i < words.length; i++) search(words, i, root, res);
    
    return res;
}
    
private void addWord(TrieNode root, String word, int index) {
    for (int i = word.length() - 1; i >= 0; i--) {
        int j = word.charAt(i) - 'a';
    	if (root.next[j] == null) root.next[j] = new TrieNode();
    	if (isPalindrome(word, 0, i)) root.list.add(index);
    	root = root.next[j];
    }
    	
    root.list.add(index);
    root.index = index;
}
    
private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
    for (int j = 0; j < words[i].length(); j++) {	
    	if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
    	    res.add(Arrays.asList(i, root.index));
    	}
    		
    	root = root.next[words[i].charAt(j) - 'a'];
      	if (root == null) return;
    }
    	
    for (int j : root.list) {
    	if (i == j) continue;
    	res.add(Arrays.asList(i, j));
    }
}
    
private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
    	if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    	
    return true;
}

*/

/*----------------------------------------------------------------------------------- 
 Problem: 

    Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.



    Example 1:
    Given words = ["bat", "tab", "cat"]
    Return [[0, 1], [1, 0]]
    The palindromes are ["battab", "tabbat"]


    Example 2:
    Given words = ["abcd", "dcba", "lls", "s", "sssll"]
    Return [[0, 1], [1, 0], [3, 2], [2, 4]]
    The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]


Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.*/