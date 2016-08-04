/*
 Question:
 Given two strings with the same characters except for one   
 additional character in one string, return that additional character. 

Reference:
Source: Glassdoor
Link: https://www.glassdoor.com/Interview/Given-two-strings-with-the-same-characters-except-for-one-additional-character-in-one-string-return-that-additional-charac-QTN_1419665.htm

*/
public class additionalCharacter{
	public static void main(String args[]){
		String s1 = "abc";
		String s2 = "aabc";

		findCharacter(s1,s2);
	}

	public static void findCharacter(String s1,String s2){
		int bigTotal = 0; 
		int smallTotal = 0;

		/*Add the ascii value of all the characters in the string s1*/
		for(int i = 0; i < s1.length(); i++){
			smallTotal += (int)s1.charAt(i);  
		}
		/*Add the ascii value of all the characters in the string s2*/
		for(int i = 0; i < s2.length(); i++){
			bigTotal += (int)s2.charAt(i);
		}
		/*The difference of the sum of the ascii values of the 2 strings gives the ascii value of the additional character
		in the 2nd string. This works because there is only 1 additional character in the 2nd string and the rest of characters 
		in the 2nd string match all the characters in the 1st string*/
		int diff = bigTotal - smallTotal;
		System.out.println("extra character is ="+(char)diff);
	}
}