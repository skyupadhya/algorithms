/*
Question:
Print unique rows in a given boolean matrix
Given a binary matrix, print all unique rows of the given matrix.

Input:
	    {0, 1, 0, 0, 1}
        {1, 0, 1, 1, 0}
        {0, 1, 0, 0, 1}
        {1, 1, 1, 0, 0}

Output:
		0 1 0 0 1 
		1 0 1 1 0 
		1 1 1 0 0 

Note: 
Reference:
Source: Geeksforgeeks
Link: http://www.geeksforgeeks.org/print-unique-rows/
*/

import java.util.*;
public class boolMatrix{
	public static void main(String args[]){

		int[][] matrix = new int[4][5];
		Scanner sc = new Scanner(System.in);
		boolMatrix matrixObj = new boolMatrix();
		boolMatrix.trie t = matrixObj.new trie();
		//give the input 0 1 0 0 1 1 0 1 1 0 0 1 0 0 1 1 1 1 0 0
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				matrix[i][j] = sc.nextInt();
			}
			t.insert(matrix[i]);
		}
	}
	//implementation of trie datastructure
	public class trie{
		//implementation of trieNode
		public class trieNode{
			int node;
			boolean isLeaf;
			HashMap<Integer,trieNode> children = new HashMap<>();

			public trieNode(){}

			public trieNode(int value){
				this.node = value;
				this.isLeaf = false;
			}
		}

		private trieNode root;

		public trie(){
			root = new trieNode();
		}
		//inserting the numbers of an array in a trie.
		public void insert(int[] arr){
			HashMap<Integer,trieNode> children = root.children;
			trieNode t = null;

			for(int i = 0; i < arr.length; i++){
				if(children.get(arr[i]) == null){
					t = new trieNode(arr[i]);
					children.put(arr[i],t);
					children = t.children;
				}else{
					t = children.get(arr[i]);
					children = t.children;
				}
			}

			//if the array is newly inserted the leaf node is always false. Print the newly inserted array
			if(t.isLeaf == false){
				for(int i = 0; i < arr.length; i++){
					System.out.print(arr[i] + ",");
				}
				System.out.println();
				t.isLeaf = true;
			}
		}

	}
}