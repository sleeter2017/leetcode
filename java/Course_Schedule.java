// https://leetcode.com//problems/course-schedule/#/description		 QuestionId:207
import java.io.*; 
import java.util.*; 
public class Solution {

    //public int[] findOrder(int numCourses, int[][] prerequisites) {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        //build graph
        for(int[] edge : prerequisites) {
            buildGraph(graph, edge[0], edge[1]);
        }
        // add all remaining vertices
        for(int vertex = 0 ; vertex < numCourses; vertex++)
            buildGraph(graph, vertex, -1);  // -1 indicates no edge


        //perform topological sort
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Stack<Integer> res = new Stack<Integer>();
        for(int node: graph.keySet()) {
            if(visited.contains(node)) {
                continue;
            }
            if(!DFS(graph, node, visited, visiting, res)) {
               // return new int[0];
               return false;
            }
        }
        int[] result = new int[numCourses];
        for(int i = numCourses-1; i >= 0 && !res.isEmpty(); i--)
            result[i] = res.pop();

        //return result;
        return true;
    }


    public void buildGraph(Map<Integer, Set<Integer>> graph, int start, int end) {
        graph.putIfAbsent(start, new HashSet<Integer>());
        if(end != -1) graph.get(start).add(end);
    }

    public boolean DFS(Map<Integer, Set<Integer>> graph, Integer root, Set<Integer> visited, Set<Integer> visiting, Stack<Integer> res) {
        if(visiting.contains(root)) return false;

        // Visit children first before visiting parent
        Set<Integer> children = graph.get(root);
        if(children != null) {
            visiting.add(root);
            for(int child: children) {
                if(visited.contains(child)) continue;
                if(!DFS(graph, child, visited, visiting, res)) return false;
            }
        }

        //now visit parent
        visited.add(root);
        visiting.remove(root);
        res.push(root);
        return true;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]


Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.



click to show more hints.

Hints:

This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.

*/