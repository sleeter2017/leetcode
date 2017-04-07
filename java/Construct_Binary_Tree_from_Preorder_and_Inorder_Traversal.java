// https://leetcode.com//problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description		 QuestionId:105
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
 //http://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
 
 /*
 The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)
*/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i; break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

/*
Problem:
Given preorder and inorder traversal of a tree, construct the binary tree.
*/
/*
I also cooked the solution of a similar problem "Construct Binary Tree from Postorder and Inorder Traversal" according to your solution.

public TreeNode buildTree(int[] inorder, int[] postorder) {
	return buildTreeInPost(postorder.length-1, 0, inorder.length-1, postorder, inorder);	
}
private TreeNode buildTreeInPost(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
	if(inStart>inEnd ||postStart<0) return null;
	TreeNode root = new TreeNode(postorder[postStart]);
	
	int inIndex = 0;
	for (int i=inStart; i<=inEnd; i++) {
		if(inorder[i] == root.val){
			inIndex = i;
			break;
		}
	}
	root.left = buildTreeInPost(postStart-(inEnd-inIndex)-1, inStart, inIndex-1, postorder, inorder);
	root.right = buildTreeInPost(postStart-1, inIndex+1, inEnd, postorder, inorder);	
	
	return root;
}

*/


/*----------------------------------------------------------------------------------- 
 Problem: 
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/