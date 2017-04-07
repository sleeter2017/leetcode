// https://leetcode.com//problems/queue-reconstruction-by-height/#/description		 QuestionId:406
import java.io.*; 
import java.util.*; 
/*
1) Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
2) For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
E.g.
input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
subarray after step 1: [[7,0], [7,1]]
subarray after step 2: [[7,0], [6,1], [7,1]]

*/

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        
		Arrays.sort(people, 
			(a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]  // comparator: this is lambda expression introduced in Java 8
			); // when height is same, sort by increasing order of k, otherwise sort by decreasing order of height
        
	        List<int[]> ans = new LinkedList<>();
	        for (int[] p : people) {
	            ans.add(p[1], p);
	        }
	        return ans.toArray(new int[0][0]);
    }
}
/*
Suppose I take only the tallest persons, all having the same maximum height. Their second values must be 0, 1, 2, 3... with no gaps at all, because they only count each other. Therefore, if there were no other persons at all, their second value must be their final index. What about the persons with second maximum height then? Suppose there are only tallest persons and just one more person who has slightly smaller height. What would be his position? Well, since he obviously only count tallest persons, his position would still be his second value. The next person of the same height counts only the previous person and all the tallest ones, but since they are all already in the queue, his second value would also be his index.
*/

/*
Problem:
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/


/*----------------------------------------------------------------------------------- 
 Problem: 
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.


Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/