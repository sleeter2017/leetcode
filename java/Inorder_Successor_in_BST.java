x// https://leetcode.com//problems/inorder-successor-in-bst/#/description		 QuestionId:285
import java.io.*; 
import java.util.*; 
//https://www.youtube.com/watch?v=5cPbNCrdotA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://discuss.leetcode.com/topic/25076/share-my-java-recursive-solution/19
public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;
    
      if (root.val <= p.val) {
        return inorderSuccessor(root.right, p);
      } else {
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null) ? left : root;
      }
    }
    
    public TreeNode predecessor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;
    
      if (root.val >= p.val) {
        return predecessor(root.left, p);
      } else {
        TreeNode right = predecessor(root.right, p);
        return (right != null) ? right : root;
      }
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/