// https://leetcode.com//problems/simplify-path/#/description		 QuestionId:71
import java.io.*; 
import java.util.*; 
//The main idea is to push to the stack every valid file name (not in {"",".",".."}), popping only if there's smth to pop and we met "..". 
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>(); // Double ended queue
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        StringBuffer res = new StringBuffer();
        for (String dir : stack) {res.insert(0,dir); res.insert(0,"/");} // Notice we are traversing elements from front as it is double ended queue. We will get reverse order if we use Stack instead of Deque
        return res.length() == 0 ? "/" : res.toString();
    }
}

/*
Problem:
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"


click to show corner cases.

Corner Cases:



Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/