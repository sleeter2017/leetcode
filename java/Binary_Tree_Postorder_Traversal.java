// https://leetcode.com//problems/binary-tree-postorder-traversal/#/description		 QuestionId:145
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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> unexplored = new Stack<TreeNode>(); // unexplored its 2 children
        Stack<TreeNode> explored = new Stack<TreeNode>();   // explored its 2 children
        
        unexplored.push(root);
        
        while(!unexplored.empty()) {
            TreeNode n = unexplored.pop();
            if(n == null) continue;

            if(n.left != null) unexplored.push(n.left);
            if(n.right != null) unexplored.push(n.right);
            explored.push(n);
        }
        // Visit all elements in stack-2
        List<Integer> lrp = new LinkedList<Integer>();
        while(!explored.empty()) {
            lrp.add(explored.pop().val);
        }
        
        return lrp;
        
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a binary tree, return the postorder traversal of its nodes' values.


For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3



return [3,2,1].


Note: Recursive solution is trivial, could you do it iteratively?*/