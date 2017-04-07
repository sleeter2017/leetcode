// https://leetcode.com//problems/integer-to-roman/#/description		 QuestionId:12
import java.io.*; 
import java.util.*; 
public class Solution {
  
  public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
} 
   
   /*
    public String intToRoman(int num) {
        
        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
        tmap.put(1,"I");
        tmap.put(4,"IV");
        tmap.put(5,"V");
        tmap.put(9,"IX");
        tmap.put(10,"X");
        tmap.put(40,"XL");
        tmap.put(50,"L");
        tmap.put(90,"XC");
        tmap.put(100,"C");
        tmap.put(400,"CD");
        tmap.put(500,"D");
        tmap.put(900,"CM");
        tmap.put(1000,"M");
        
        StringBuilder roman = new StringBuilder();
        
        for(;num > 0;) {
            //floorkey: Returns the greatest key less than or equal to the given key, or null if there is no such key.
            Integer key = tmap.floorKey(num);
            // what if key is null ? such case doesnt exist
            roman.append(tmap.get(key));
            num -= key;
        }
        return roman.toString();
    }
    */
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given an integer, convert it to a roman numeral.


Input is guaranteed to be within the range from 1 to 3999.*/