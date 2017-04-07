// https://leetcode.com//problems/maximal-rectangle/#/description		 QuestionId:85
import java.io.*; 
import java.util.*; 
// https://leetcode.com//problems/maximal-rectangle/		 QuestionId:85
/*  Explanation:https://www.youtube.com/watch?v=g8bSdXCG-lA
Max area in histogram: https://www.youtube.com/watch?v=VNbkzsnllsU
Max area in histogram: https://www.youtube.com/watch?v=ZmnqCZp9bBs
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestRectangleArea(height);
        for(int i = 1; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestRectangleArea(height));
        }
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    } 
    
    /* The following is same as: https://leetcode.com/problems/largest-rectangle-in-histogram/
    Explanation: https://www.youtube.com/watch?v=VNbkzsnllsU
    https://www.youtube.com/watch?v=ZmnqCZp9bBs
    */
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}

/*
Problem:
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

Solution:
We can apply the maximum in histogram in each row of the 2D matrix. What we need is to maintain an int array for each row, which represent for the height of the histogram.

Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/ first.

Suppose there is a 2D matrix like

1 1 0 1 0 1

0 1 0 0 1 1

1 1 1 1 0 1

1 1 1 1 0 1

First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.

Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.

Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 2, so the max area has been found as 2 * 4 = 8.

Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
*/
/*----------------------------------------------------------------------------------- 
 Problem: 

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.


For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 6.
*/