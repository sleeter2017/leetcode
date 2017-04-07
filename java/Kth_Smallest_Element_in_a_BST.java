// https://leetcode.com//problems/kth-smallest-element-in-a-bst/#/description		 QuestionId:230
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
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(root);
        int count = 0;
        
        while(!stack.isEmpty() || cur != null) {
            if(cur != null ) {
                stack.push(cur);
                cur = cur.left;
            } else { //reached left most node
                //visit Node
                count++;
                cur = stack.pop();
                if(count ==k) return cur.val;
                cur = cur.right;
                
            }
        }
        return -1;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
