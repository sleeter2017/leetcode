// https://leetcode.com//problems/invert-binary-tree/#/description		 QuestionId:226
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        /* Recursive
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;  */

        /*Iterative*/
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = tmp;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }


        return root;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        else return left != null ? left : right;
    }
}

/*
// https://leetcode.com//problems/clone-graph/		 QuestionId:133
/**
 * Definition for undirected graph.
 * class Graph {
 *     int label;
 *     List<Graph> neighbors;
 *     Graph(int x) { label = x; neighbors = new ArrayList<Graph>(); }
 * };
 
public class Solution {
    public Graph cloneGraph(Graph node) {
        return cloneGraph(node, new HashMap<Graph, Graph>());
    }
    
    private Graph cloneGraph(Graph node, Map<Graph, Graph> cloneMap) {
        if (node == null) return null;
        Graph cloned = new Graph(node.label);
        cloneMap.put(node, cloned); // visited = true;
        for(Graph neighbor: node.neighbors){
            if (cloneMap.containsKey(neighbor)) { // if we have already explored this vertex grab its clone from map
                cloned.neighbors.add(cloneMap.get(neighbor));
            } else { // explore unvisited vertex
                cloned.neighbors.add(cloneGraph(neighbor, cloneMap));
            }
        }
        return cloned;
    }
}
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
