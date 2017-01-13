/*
Question:
Context
Given a 6 x 6 2D Array,A : 

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
a b c
  d
e f g
There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values. 

Task
Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.

Input Format
There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A; 
every value in A will be in the inclusive range of -9 to 9.

Constraints
1) -9 <= A[i][j] <= 9
2) 0 <= i,j <= 5

Output Format
Print the largest (maximum) hourglass sum found in A.

Sample Input:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output

19

Reference:
Source: HackerRank
Link: https://www.hackerrank.com/challenges/2d-array
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();  //Filling the input array
            }
        }
       findMaxSumHourGlass(arr); //calling the method
    }
    /*Find the sum of the 7 numbers ie, 
      from an index the value of the index and next 2 consecutive numbers in the same row,
      middle number in the next row and 
      the next 3 consecutive numbers in the next row.
      If it is larger than the current maxSum so far then update maxSum*/
    public static void findMaxSumHourGlass(int[][] arr){
        int maxSum = Integer.MIN_VALUE; //inital value of maxSum is the lowest possible integer
        
        for(int i = 0;i+2< arr.length; i++){
            for(int j = 0; j + 2 < arr[0].length; j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]+
                         + arr[i+1][j+1] + 
                          arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }
}

/*Extra test cases:
Input:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0 
0 0 0 2 0 0
0 0 1 2 4 0
Output
19

Input
-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5

Output:
-6
*/