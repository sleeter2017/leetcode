// https://leetcode.com//problems/longest-common-prefix/#/description		 QuestionId:14
import java.io.*; 
import java.util.*; 
public class Solution {

    
    public String longestCommonPrefix(String[] strs) {
        
        if( strs == null || strs.length == 0 ) return "";
        
        if( strs.length == 1 ) return strs[0];
        
        // find the smallest string
        int slen = Integer.MAX_VALUE;
        for(int i =0; i < strs.length; i++) {
            if(strs[i].length() < slen ) slen = strs[i].length();
        }
        
        for(int i =0 ;i < slen ; i++) {
            char source = strs[0].charAt(i);
            for( int j = 1; j < strs.length; j++ ) {
                if(source != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        
        return strs[0].substring(0,slen);
        
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Write a function to find the longest common prefix string amongst an array of strings.
*/