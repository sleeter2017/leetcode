// https://leetcode.com//problems/validate-binary-search-tree/#/description		 QuestionId:98
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
    Solution: Traverse InOrder, comparing element to its previous
 */
public class Solution {
    int prev = Integer.MIN_VALUE;
    boolean firstElement = true; // This is to handle corner case where element could be of value Integer.MIN_VALUE
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        boolean left = isValidBST(root.left);
        if(!firstElement && root.val <= prev) {return false;}
            else { 
                firstElement = false; 
                prev = root.val; 
            }
        boolean right= isValidBST(root.right);
        
        return left && right;
        
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a binary tree, determine if it is a valid binary search tree (BST).



Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.



Example 1:

    2
   / \
  1   3

Binary tree [2,1,3], return true.


Example 2:

    1
   / \
  2   3

Binary tree [1,2,3], return false.
*/