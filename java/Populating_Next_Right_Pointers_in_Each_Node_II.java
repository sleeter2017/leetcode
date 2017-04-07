// https://leetcode.com//problems/populating-next-right-pointers-in-each-node-ii/#/description		 QuestionId:117
import java.io.*; 
import java.util.*; 
// Solution is same as: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode tempLeftMostChild = new TreeLinkNode(0);
        while (root != null) { // To go through all levels
            TreeLinkNode currentChild = tempLeftMostChild;
            while (root != null) {  // To go through all nodes at the same level
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempLeftMostChild.next; // Go to left-most child of the next level
            tempLeftMostChild.next = null; // Reset
        }
    }
}

/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work? YES

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?

Note:
You may only use constant extra space.


For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7



After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/