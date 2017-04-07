// https://leetcode.com//problems/top-k-frequent-elements/#/description		 QuestionId:347
import java.io.*; 
import java.util.*; 
/*
Idea is simple. Build an array of list to be buckets with length 1 to sort.
*/
public class Solution {
public List<Integer> topKFrequent(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    /* Build frequency map. eg. suppose we have: 1,1,1,2,2,3,3,4
        The bucket would look like:
        3 -> 1
        2 -> 2,3
        1 -> 4
        The index indicates the frequency. Now, just start from the end and return k elements
    
    */
	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

    for(int pos = bucket.length-1; pos >= 0; pos--){
        if(bucket[pos] != null){
            for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                res.add(bucket[pos].get(i));
        }
    }
	return res;
}
}
/*----------------------------------------------------------------------------------- 
 Problem: 
