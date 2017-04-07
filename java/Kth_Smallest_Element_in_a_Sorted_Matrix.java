// https://leetcode.com//problems/kth-smallest-element-in-a-sorted-matrix/#/description		 QuestionId:378
import java.io.*; 
import java.util.*; 
/*
1. Build a minHeap of elements from the first row.
2. Do the following operations k-1 times :
Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number of that element(so we can create a tuple class here), replace that root with the next element from the same column.
After you finish this problem, thinks more :

1.For this question, you can also build a min Heap from the first column, and do the similar operations as above.(Replace the root with the next element from the same row)
2.What is more, this problem is exact the same with Leetcode373 Find K Pairs with Smallest Sums, I use the same code which beats 96.42%, after you solve this problem, you can check with this link:
https://discuss.leetcode.com/topic/52953/share-my-solution-which-beat-96-42

*/
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b) -> a.val - b.val);
        
        for(int j = 0; j < cols; j++) pq.offer(new Tuple(0, j, matrix[0][j])); // copy entire first row
        
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == rows-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
