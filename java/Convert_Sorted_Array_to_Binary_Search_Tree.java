// https://leetcode.com//problems/convert-sorted-array-to-binary-search-tree/#/description		 QuestionId:108
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sort(nums, 0, nums.length-1);
        return root;
    }
    
    public TreeNode sort(int[] nums, int low, int high) {
        if(low > high) return null;
        
        int mid = (low + high)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sort(nums, low, mid-1);
        node.right = sort(nums, mid+1, high);
        return node;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/