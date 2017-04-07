// https://leetcode.com//problems/unique-word-abbreviation/#/description		 QuestionId:288
import java.io.*; 
import java.util.*; 
public class ValidWordAbbr {

    HashMap<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        StringBuffer sb = new StringBuffer();
        
        for(String word : dictionary) {
            String abbr = getAbbr(sb, word);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(abbr) && !map.get(abbr).equals(word))
                map.put(abbr, "");
            else
                map.put(abbr, word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(null,word);
        
        //if(!map.containsKey(abbr) || map.get(abbr).equals(word)) return true;
        //return false;
        return (!map.containsKey(abbr) || map.get(abbr).equals(word));
    }
    
    public String getAbbr(StringBuffer sb, String word) {
        if(word.length() < 2) return word;
        
        if(sb == null) sb = new StringBuffer();
        sb.setLength(0);
        sb.append(word.charAt(0));
        sb.append(word.length()-2);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
/*----------------------------------------------------------------------------------- 
 Problem: 
LeetCode Online Judge is a platform for preparing technical coding interviews and assessing your knowledge of data structures and algorithms. Pick from our expanding library of more than 160 interview questions to solve. Use our automated tool to get real time feedback on your solution.*/