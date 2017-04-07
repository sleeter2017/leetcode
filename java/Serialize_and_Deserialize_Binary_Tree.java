// https://leetcode.com//problems/serialize-and-deserialize-binary-tree/#/description		 QuestionId:297
import java.io.*; 
import java.util.*; 
//Queue cannot store null, while Deque can.
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
 The idea is simple: print the tree in pre-order traversal and use "#" to denote null node and split node with ",". We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store the pre-order traversal and since we have "#" as null node, we know exactly how to where to end building subtress.
 */
import java.util.*;
public class Codec {

    public String serialize(TreeNode root) {

        return serial(new StringBuilder(), root).toString();
    }
    
    // Pre-order traversal: PLR
    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) return str.append("#");
        str.append(root.val).append(",");
        serial(str, root.left).append(","); // note execution order
        return serial(str, root.right);
    }

    public TreeNode deserialize(String data) {
        String[] preOrderData = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(preOrderData));
        return deserial(q);
    }
    
    private TreeNode deserial(Queue<String> queue) {
        String val = queue.poll(); // return null if empty
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(queue);
        root.right = deserial(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/*
Problem:
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. 

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.


For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


Credits:Special thanks to @Louis1992 for adding this problem and creating all test cases.*/