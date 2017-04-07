// https://leetcode.com//problems/roman-to-integer/#/description		 QuestionId:13
import java.io.*; 
import java.util.*; 
// https://leetcode.com/problems/roman-to-integer/#/solutions uber
//count every Symbol and add its value to the sum, and minus the extra part of special cases.
public class Solution {
    public int romanToInt(String s) {
         int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}
        
    
        
       for(char ch : s.toCharArray()){
           if(ch =='M') sum+=1000;
           if(ch =='D') sum+=500;
           if(ch =='C') sum+=100;
           if(ch =='L') sum+=50;
           if(ch =='X') sum+=10;
           if(ch =='V') sum+=5;
           if(ch =='I') sum+=1;
           
       }
       
       return sum;
        
    }
}
/*----------------------------------------------------------------------------------- 
 Problem: 
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/