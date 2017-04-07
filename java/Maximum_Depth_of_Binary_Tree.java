// https://leetcode.com//problems/maximum-depth-of-binary-tree/#/description		 QuestionId:104
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
    public int maxDepth(TreeNode root) {
        return maxHelper(root, new HashMap<TreeNode, Integer>(),0);
    }
    
    public int maxHelper(TreeNode root, HashMap<TreeNode, Integer> memo,int height) {
        if(root == null) return height;
        if(memo.get(root) != null) return memo.get(root);
        
        int left = maxHelper(root.left, memo, height+1);
        int right = maxHelper(root.right, memo, height+1);
        
        int maxHeight = Math.max(left,right);
        memo.put(root, maxHeight);
        return maxHeight;
    }
}

/* Without memo

    public int maxDepth(TreeNode root) {
        return maxHelper(root,0);
    }
    
    public int maxHelper(TreeNode root, int height) {
        if(root == null) return height;
        
        int left = maxHelper(root.left, height+1);
        int right = maxHelper(root.right, height+1);
        
        return Math.max(left,right);
    }
    
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*/