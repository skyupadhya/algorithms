/*
 Question:
Shil has a string, S , consisting of N lowercase English letters. In one operation, 
he can delete any pair of adjacent letters with same value. For example, string "aabcc" would 
become either "aab" or "bcc" after 1 operation.

Shil wants to reduce S as much as possible. To do this, he will repeat the above operation as 
many times as it can be performed. Help Shil out by finding and printing S's non-reducible form!

Note: If the final string is empty, print Empty String.

Reference:
Source: HackerRank
Link: https://www.hackerrank.com/challenges/reduced-string
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        /*arr will hold the characters in the final reduced string*/
        char[] arr = new char[input.length()];
        /*index is the position initialized with the first character of the input string
         It keeps track of the character array arr*/
        int index = 0;
        arr[index] = input.charAt(0);
        
        for(int i = 1; i < input.length(); i++){
           /*store the character of input string in the arr if the input string character and the 
           character at the index position in the arr dont match. This is done by incrementing the index of the arr.
           If they match reset the character at the index position in the arr with null and decrement index

           Continous decrements on match can make the index negative. In such case reset the index and store the input 
           string character*/
           if(index < 0 ){
               index = 0;
               arr[index] = input.charAt(i);
           }else if(input.charAt(i) == arr[index]){
               arr[index] = '\0';
               index--;
           }else if(input.charAt(i) != arr[index]){
               index++;
               arr[index] = input.charAt(i);
           }
        }
       
        if(index < 0)
            System.out.println("Empty String");
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= index; i++){
                sb.append(arr[i]);
            }
            System.out.println(sb);
        }
    }
}