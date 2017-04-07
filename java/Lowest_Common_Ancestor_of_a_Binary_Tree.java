// https://leetcode.com//problems/lowest-common-ancestor-of-a-binary-tree/#/description		 QuestionId:236
import java.io.*; 
import java.util.*; 
//https://www.youtube.com/watch?v=13m9ZCB8gjw&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO&index=3

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null ) return root;
        if( root == p || root == q) return root;
        
        // search in both left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        else return left != null ? left : right;
    }
    
   public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        
        //base case
        if (root == null ) return root;
        if( root == p || root == q) return root;

        
        if( root.val < Math.min(p.val, q.val) ) return lowestCommonAncestor(root.right, p, q);
        else if( root.val > Math.max(p.val, q.val) ) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }
}
// Same as: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
LCA of BST
1.Both nodes are to the left of the tree.
2.Both nodes are to the right of the tree.
3.One node is on the left while the other is on the right.
4.When the current node equals to either of the two nodes, this node must be the LCA too.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
