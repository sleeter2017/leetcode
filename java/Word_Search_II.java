// https://leetcode.com//problems/word-search-ii/#/description		 QuestionId:212
import java.io.*; 
import java.util.*; 
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        
        //Build Trie
        TrieNode root = new TrieNode();
        for(String word : words) insert(root, word);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.setLength(0);
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int row, int col, TrieNode current, List<String> res) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length) return;
        char c = board[row][col];
        if (c == '#') return;
        
        TrieNode node = current.children.get(c);
        if(node == null) return;
        current = node;
        if(current.word != null) {
            res.add(current.word);
            current.word = null; // de-duplicate
        }
        
    
        board[row][col] = '#';
        dfs(board, row - 1, col , current, res);
        dfs(board, row, col - 1,  current, res);
        dfs(board, row + 1, col, current, res); 
        dfs(board, row, col + 1, current, res); 
        board[row][col] = c;
    }
    
    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for(char ch: word.toCharArray()) {
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        //mark the current nodes endOfWord as true
        cur.word = word;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        // Initialize your data structure here.
        public TrieNode() {
            children = new HashMap<>();
            word = null;
        }
    }
}

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a 2D board and a list of words from the dictionary, find all words in the board.


Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



For example,
Given words = ["oath","pea","eat","rain"] and board = 

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]


Return ["eat","oath"].



Note:
You may assume that all inputs are consist of lowercase letters a-z.


click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/