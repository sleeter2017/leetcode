// https://leetcode.com//problems/number-of-connected-components-in-an-undirected-graph/#/description		 QuestionId:323
import java.io.*; 
import java.util.*; 
// This is similar to: https://leetcode.com/problems/graph-valid-tree/
public class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int sets[] = new int[n];
        Arrays.fill(sets, -1); //initialize n disjoint sets
        
        for(int i=0; i < edges.length; i++) {
            int x = find(sets, edges[i][0]); //find the set where x exists
            int y = find(sets, edges[i][1]); //find the set where y exists
            //if(x == y) return false; // both exist in same set, so there is cycle
            
            if(x!=y) sets[x] = y; // make 'y' parent of 'x'; UNION
        }
        // Number of -1 gives disjoint sets, which is number of connected components
        int count = 0;
        for(int vertex:sets) if(vertex==-1) count++;
        
        return count;
    }
    
    public int find(int[] sets, int vertex) {
        if(sets[vertex] == -1) return vertex;
        return find(sets, sets[vertex]); //recursively find the topmost parent
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/