// https://leetcode.com//problems/alien-dictionary/#/description		 QuestionId:269
import java.io.*; 
import java.util.*; 
public class Solution {

    // if n == 0, no neighbor, just create vertex node
    public static void addEdge(Map<Character, Set<Character>> graph, char node, char n) {
        
        graph.putIfAbsent(node, new HashSet<Character>());
        if(n!=0 && !graph.get(node).contains(n)) // here we are searching entire list, we can replace it with HashSet
            graph.get(node).add(n);
    }


    public static void buildGraph(Map<Character, Set<Character>> graph, String[] words) {
        //There should be atleast 2 words to determine any ordering
        if(words == null || words.length < 2) return;

        String prev = words[0];
        boolean found = false;
        for(int i = 1; i < words.length; i++) {
            //find invalid lexicograph ordering
            if(words[i-1].length() > words[i].length() && words[i-1].startsWith(words[i])) {
                // abcd, abc
                graph = null;
                return;
            }
            String cur = words[i];
            int len = Math.min(prev.length(),cur.length());
            for(int j = 0; j < len; j++) {
                if(cur.charAt(j) != prev.charAt(j)) {
                    addEdge(graph, prev.charAt(j), cur.charAt(j));
                    break; // as soon as first mismatch is found, break. we cannot find anymore ordering
                }
            }
            prev = cur;
        }
        // Now add the remaining characters into Graph
        for(String word: words)
            for(char cur : word.toCharArray())
                addEdge(graph, cur, (char)0);

    }

    public static String topologicalSort(Map<Character, Set<Character>> graph ) {
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        LinkedList<Character> resstack = new LinkedList<>();

        for(char node: graph.keySet()) {
            if(visited.contains(node)) continue;
            if(!DFS(node, graph, visited, visiting, resstack)) // if cycle is detected, return empty string
                return "";
        }

        StringBuilder res = new StringBuilder();
        while(!resstack.isEmpty()) {
            res.append(resstack.pop());
        }
        return res.toString();
    }

    public static boolean DFS(char root, Map<Character, Set<Character>> graph, Set<Character> visited, Set<Character> visiting, LinkedList<Character> resstack) {

        if(visiting.contains(root)) return false; // Cycle detected: if already visited, its not a DAG, return false

        Set<Character> children = graph.get(root);
        if(children != null) { // visit children first before visiting parent ( dependency )
            visiting.add(root);
            for (Character child : children) {
                if (visited.contains(child))  continue;
                if(!DFS(child, graph, visited, visiting, resstack)) return false;
            }
        }
        visited.add(root); // all children are visited, now visit parent
        visiting.remove(root);
        resstack.addFirst(root);
        return true;
    }

    public static String alienOrder(String[] words) {

        //check a corner case
        if(words.length == 1) return words[0];
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words);


        //perform topological sort

        return topologicalSort(graph);
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/