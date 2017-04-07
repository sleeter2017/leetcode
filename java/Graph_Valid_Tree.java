// https://leetcode.com//problems/graph-valid-tree/#/description		 QuestionId:261
import java.io.*; 
import java.util.*; 
// Concept Explanation: https://www.youtube.com/watch?v=n_t0a_8H8VY
// Implementation explanation: http://www.geeksforgeeks.org/union-find/
// Similar problem: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        int []sets = new int[n];
        Arrays.fill(sets, -1); // initialize n disjoint sets
        
        for(int i=0; i < edges.length; i++) {
            int x = findSet(sets, edges[i][0]); //find the set where x exists
            int y = findSet(sets, edges[i][1]); //find the set where y exists
            
            if(x == y) return false; // both exist in same set, so there is cycle
            
            sets[x] = y; // make 'y' parent of 'x';
        }
        
        return edges.length == n-1;
    }
    
    //DFS
    public int findSet(int[] sets, int vertex) {
        if(sets[vertex] == -1) return vertex;
        
        return findSet(sets, sets[vertex]); //recursively find the topmost parent
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/