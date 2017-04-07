// https://leetcode.com//problems/find-median-from-data-stream/#/description		 QuestionId:295
import java.io.*; 
import java.util.*; 
//https://leetcode.com/problems/find-median-from-data-stream/#/description
/*
I keep two heaps (or priority queues):

Max-heapSmall has the smaller half of the numbers.
Min-heapLarge has the larger half of the numbers.
This gives me direct access to the one or two middle values (they're the tops of the heaps), so getting the median takes O(1) time. And adding a number takes O(log n) time.

Avoid integer overflow by using a simple mathematical formula: (a+b)/2 == a/2 + b/2
*/

import java.util.PriorityQueue;
import java.util.*;

class MedianFinder {

    //Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
    private Queue<Integer> maxHeapSmall = new PriorityQueue<Integer>((a,b) -> b.compareTo(a)), // maxHeapSmall
            minHeapLarge = new PriorityQueue<Integer>((a,b) -> (a.compareTo(b)));  // minHeapLarge, default without lambda expression

    /* Always maintain this property: minHeapLarge >= maxHeapSmall */
    public void addNum(int num) {
        minHeapLarge.add(num);
        maxHeapSmall.add(minHeapLarge.poll());
        if (minHeapLarge.size() < maxHeapSmall.size())
            minHeapLarge.add(maxHeapSmall.poll());
    }

    public double findMedian() {
        return minHeapLarge.size() > maxHeapSmall.size()
                ? minHeapLarge.peek()
                : (minHeapLarge.peek()/2.0 + maxHeapSmall.peek()/2.0); //Avoid integer overflow by using a simple mathematical formula: (a+b)/2 == a/2 + b/2
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
 /*
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
Examples: 
[2,3,4] , the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5 


Design a data structure that supports the following two operations:


void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.



For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2


Credits:Special thanks to @Louis1992 for adding this problem and creating all test cases.*/