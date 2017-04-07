// https://leetcode.com//problems/binary-tree-inorder-traversal/#/description		 QuestionId:94
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> inorderList = new ArrayList<Integer>();
        
        TreeNode cur = root;
        while( !stack.isEmpty() || cur != null ) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else { // cur is NULL, reached leftmost node
                cur = stack.pop();
                inorderList.add(cur.val);
                cur = cur.right;
            }
        }
        return inorderList;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a binary tree, return the inorder traversal of its nodes' values.


For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3



return [1,3,2].


Note: Recursive solution is trivial, could you do it iteratively?*/