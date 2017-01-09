/*	
	Source: Cracking the coding interview 5th Edition. 
	Chapter: 11
	Page no:122
	Question no: 11.6

	Given an M x N matrix in which each row and each column is sorted in ascending order, write a method to find
	an element in it.
*/
public class sortedMatrix{
	public static void main(String args[]){
		int[][] a = {
						{15,20,70,85},
						{20,35,80,95},
						{30,55,95,105},
						{40,80,100,120}
					};
		System.out.println("Is 4 present in array = "+search(a,4));
		System.out.println("Is 40 present in array = "+search(a,40));
	}

	public static boolean search(int[][] a,int key){
		int columnIndex = a[0].length-1;
		int rowIndex = 0;
		//start comparison from the last column of the first row of the matrix
		//if the key matches return true
		//if key is greater than the element move down
		//if the key is smaller than the element move left(reduce the column index)
		while(rowIndex <= a.length-1 && columnIndex >= 0){
			if(key == a[rowIndex][columnIndex])
				return true;
			else if(key > a[rowIndex][columnIndex])
				rowIndex++;
			else if(key < a[rowIndex][columnIndex])
				columnIndex--;
		}

		return false;
	}
}