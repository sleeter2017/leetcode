// https://leetcode.com//problems/clone-graph/#/description		 QuestionId:133
import java.io.*; 
import java.util.*; 
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
        if (node == null) return null;
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        cloneMap.put(node, cloned); // visited = true;
        for(UndirectedGraphNode neighbor: node.neighbors){
            if (cloneMap.containsKey(neighbor)) { // if we have already explored this vertex grab its clone from map
                cloned.neighbors.add(cloneMap.get(neighbor));
            } else { // explore unvisited vertex
                cloned.neighbors.add(cloneGraph(neighbor, cloneMap));
            }
        }
        return cloned;
    }
}

/*  Invert a binary tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }
}
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.




OJ's undirected graph serialization:


Nodes are labeled uniquely.


We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.




As an example, consider the serialized graph {0,1,2#1,2#2,2}.



The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.




Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/



*/