// https://leetcode.com//problems/number-of-islands-ii/#/description		 QuestionId:305
import java.io.*; 
import java.util.*; 
// https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations/2
public class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 4 neighbors
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;
    
        int count = 0;                      // number of islands
        int[] sets = new int[m * n];       // one island = one tree
        Arrays.fill(sets, -1);            
    
        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            sets[root] = root;             // add new island
            count++;
    
            for(int[] dir : dirs) { // check all 4 neighbors of newly added position
                int x = p[0] + dir[0]; 
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || sets[nb] == -1) continue;
                
                int rootNb = findSet(sets, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    sets[root] = rootNb;   // union two islands 
                    root = rootNb;          // current tree root = joined tree root
                    count--;               
                }
            }
    
            result.add(count);
        }
        return result;
    }
    
    public int findSet(int[] sets, int vertex) {
        //no recursion here
        while(vertex != sets[vertex]) vertex = sets[vertex];
        return vertex;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/