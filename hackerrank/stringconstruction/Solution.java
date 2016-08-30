/*
 Question:
 Amanda has a string, s, of m lowercase letters that she wants to copy into a new string, p. She can perform the following operations any number of times to construct string p:

Append a character to the end of string p at a cost of 1 dollar.
Choose any substring of p and append it to the end of p at no charge.
Given n strings (i.e.,s0,s1,....,sn-1 ), find and print the minimum cost of copying each s(i) to p(i) on a new line.

Reference:
Source: HackerRank
Link: https://www.hackerrank.com/challenges/string-construction
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            findMinimumCost(s);
        }
    }
    
    public static void findMinimumCost(String s){
        HashSet<Character> charInStr = new HashSet<>();
        int cost = 0;
        for(int i = 0; i < s.length(); i++){
        	/*Search if the character is present in hashset.
        	if it is not present increment the cost by 1
        	else no charge*/
            if(!charInStr.contains((Character)s.charAt(i))){
                charInStr.add(s.charAt(i));
                cost++;
            }
        }
        
        System.out.println(cost);
    }
}