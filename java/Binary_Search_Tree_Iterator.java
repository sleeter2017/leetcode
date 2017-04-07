// https://leetcode.com//problems/binary-search-tree-iterator/#/description		 QuestionId:173
import java.io.*; 
import java.util.*; 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack = null;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        //if(stack.isEmpty()) return -1;
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    private void pushAll(TreeNode node) {
        for(;node != null; node=node.left)
            stack.push(node);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*----------------------------------------------------------------------------------- 
 Problem: 
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 

Credits:Special thanks to @ts for adding this problem and creating all test cases.*/