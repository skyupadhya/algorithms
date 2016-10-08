/*
Question:
A kidnapper wrote a ransom note but is worried it will be traced back to him. 
He found a magazine and wants to know if he can cut out whole words from it 
and use them to create an untraceable replica of his ransom note. 
The words in his note are case-sensitive and he must use whole words 
available in the magazine, meaning he cannot use substrings or 
concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, 
print Yes if he can replicate his ransom note exactly using whole words 
from the magazine; otherwise, print No.

Note: 
Reference:
Source: HackerRank
Link: https://www.hackerrank.com/challenges/ctci-ransom-note
*/
import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    //constructor 
    public Solution(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        //splitting the sentences from magazine and note based on space
        String[] magazineWords = magazine.split(" ");
        String[] noteWords = note.split(" ");
        //populating magazineMap
        for(int i = 0; i < magazineWords.length; i++){
            String word = magazineWords[i];
            Integer wordCount = null;
            if(magazineMap.containsKey(word)){
               wordCount = magazineMap.get(word);
            }
            if(wordCount == null){
                magazineMap.put(magazineWords[i],1);
            }else{
                magazineMap.put(magazineWords[i],wordCount+1);
            }
        }
        //populating noteMap
        for(int i = 0; i < noteWords.length; i++){
            Integer wordCount = noteMap.get(noteWords[i]);

            if(wordCount == null){
                noteMap.put(noteWords[i],1);
            }else{
                noteMap.put(noteWords[i],wordCount+1);
            }
        }
    }
    /*go through the noteMap and get the word and its number of occurence
      get the same word from magazineMap and get its number of occurence
      compare both number of occurences
      if noteMap has more times the word than magazineMap then ransom note cannot be replicated
      else can be replicated*/ 
    public boolean solve() {
        for(Map.Entry obj : noteMap.entrySet()){
            String word = (String)obj.getKey();
            Integer wordCountInNote = (Integer)obj.getValue();
            Integer wordCountInMagazine = magazineMap.get(word);
            if(wordCountInNote > wordCountInMagazine)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
