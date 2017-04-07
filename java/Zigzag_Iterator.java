// https://leetcode.com//problems/zigzag-iterator/#/description		 QuestionId:281
import java.io.*; 
import java.util.*; 
public class ZigzagIterator {
    Queue<Iterator> q = null;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        if(!v1.isEmpty()) q.offer(v1.iterator()); // offer means add
        if(!v2.isEmpty()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator cur = q.poll(); // poll means remove
        int res = (int)cur.next();
        if(cur.hasNext()) q.offer(cur);
        
        return res;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/