// https://leetcode.com//problems/binary-tree-preorder-traversal/#/description		 QuestionId:144
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
    // Solution with single Stack
    public List<Integer> preorderTraversal(TreeNode root) {
     
         List<Integer> preorderList = new ArrayList<Integer>();
        if(root == null) return preorderList;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while( !stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorderList.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        
        return preorderList;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a binary tree, return the preorder traversal of its nodes' values.


For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3



return [1,2,3].


Note: Recursive solution is trivial, could you do it iteratively?*/