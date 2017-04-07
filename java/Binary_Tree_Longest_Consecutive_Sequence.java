// https://leetcode.com//problems/binary-tree-longest-consecutive-sequence/#/description		 QuestionId:298
import java.io.*; 
import java.util.*; 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return DFS(root, 0, root.val,0);
    }
    
    private int DFS(TreeNode root,int cur, int target, int max) {
        if(root == null) return max;
        
        if(root.val == target) cur++;
        else cur = 1;
        
        max = Math.max(max, cur);
        int leftmax = DFS(root.left, cur, root.val+1, max);
        int rightmax = DFS(root.right, cur, root.val+1, max);
        return Math.max(leftmax, rightmax);
    }
}

/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/