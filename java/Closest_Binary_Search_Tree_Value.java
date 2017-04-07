// https://leetcode.com//problems/closest-binary-search-tree-value/#/description		 QuestionId:270
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
    public int closestValue(TreeNode root, double target) {
        int ret = (root == null) ? -1:root.val;
        
        while(root != null) {
            if(Math.abs(target - root.val) < Math.abs(target - ret))
                ret = root.val;
            root = root.val > target ? root.left:root.right;
        }
        return ret;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/