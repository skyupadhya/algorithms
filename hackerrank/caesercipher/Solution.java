/*
Question:
Julius Caesar protected his confidential information by encrypting it in a cipher. 
Caesar's cipher rotated every letter in a string by a fixed number,K , making it unreadable by his enemies. 
Given a string, S , and a number,K , encrypt S  and print the resulting string.

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
Reference:
Source: HackerRank
Link: https://www.hackerrank.com/challenges/caesar-cipher-1
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //length of the string
        String s = in.next(); //string
        int k = in.nextInt(); //rotationByK
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < n; i++){
            
            int charValue = (int)s.charAt(i);
            //handling the uppercase letters A-Z 
            if(charValue >= 65 && charValue <= 90){
                int rotatedValue = charValue + k;
                if(rotatedValue > 90){
                    int diff = rotatedValue - 90;
                    diff = diff % 26;
                    if(diff != 0)
                        rotatedValue = 64 + diff; //handle a-y , 1st 25 characters
                    else 
                        rotatedValue = 64 + 26; //handle Z case, 26th character
                }
                sb.append((char)rotatedValue);
            }else if(charValue >= 97 && charValue <= 122){ //handling the lowercase letters a-z
                int rotatedValue = charValue + k;
                if(rotatedValue > 122){
                    int diff = rotatedValue - 122;
                    diff = diff % 26;
                    if(diff != 0)
                        rotatedValue = 96 + diff; //handle A-Y, 1st 25 characters
                    else
                        rotatedValue = 96 + 26; //handle z case, 26th character
                }
                sb.append((char)rotatedValue);
            }else  //handling any other characters - no rotation
                sb.append(s.charAt(i));
        }
        
        System.out.println(sb);
    }
}
