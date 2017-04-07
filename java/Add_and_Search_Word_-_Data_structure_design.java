// https://leetcode.com//problems/add-and-search-word-data-structure-design/#/description		 QuestionId:211
import java.io.*; 
import java.util.*; 
class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;
    
    public TrieNode(){
        children = new HashMap<Character, TrieNode>();
        endOfWord = false;
    }
}
public class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()) {
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        //mark the current nodes endOfWord as true
        cur.endOfWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        
        char ch = word.charAt(index);
        if(ch == '.') {
            for(TrieNode child: current.children.values())
                if(searchRecursive(child, word, index+1))
                    return true;
                    
            //return false; // dint find match in all possible paths       
        } 
        TrieNode child = current.children.get(ch);
        if(child == null) return false;
        else 
            return searchRecursive(child, word, index+1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

/*
Problem:
similar to: https://leetcode.com/problems/implement-trie-prefix-tree/
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Design a data structure that supports the following two operations:


void addWord(word)
bool search(word)



search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.


For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true



Note:
You may assume that all words are consist of lowercase letters a-z.


click to show hint.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/