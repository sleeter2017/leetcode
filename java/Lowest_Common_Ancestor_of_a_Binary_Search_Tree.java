// https://leetcode.com//problems/lowest-common-ancestor-of-a-binary-search-tree/#/description		 QuestionId:235
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
/*
LCA of BST
1.Both nodes are to the left of the tree.
2.Both nodes are to the right of the tree.
3.One node is on the left while the other is on the right.
4.When the current node equals to either of the two nodes, this node must be the LCA too.
*/
// same as: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //return left == null ? right : right == null ? left : root;
        if(left != null && right != null) return root;
        else return left != null ? left : right;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
