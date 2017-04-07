// https://leetcode.com//problems/binary-tree-paths/#/description		 QuestionId:257
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        DFS(root, "", res);
        return res;
    }
    
    public void DFS(TreeNode root, String path, List<String> res) {
        if(root == null) return;
        // if leaf, add to result
        if(root.left == null && root.right == null) res.add(path+root.val);
        // one of left/right or both are not null, so traverse further down
        if(root.left !=null) DFS(root.left, path+root.val+"->",res);
        if(root.right !=null) DFS(root.right, path+root.val+"->",res);
    }
}

/*
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        DFS(root, path, res);
        return res;
    }

    public void DFS(TreeNode root, StringBuilder path, List<String> res) {
        if(root == null) return;

        int len = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            // atlease one of left/right subtree is not null, so traverse further down
            path.append("->");
            if(root.left !=null)DFS(root.left, path,res);
            if(root.right !=null)DFS(root.right, path,res);
        }
        path.setLength(len); // backtrack. THIS IS IMPORTANT
    }
}
 */
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a binary tree, return all root-to-leaf paths.


For example, given the following binary tree:



   1
 /   \
2     3
 \
  5



All root-to-leaf paths are:
["1->2->5", "1->3"]


Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.*/