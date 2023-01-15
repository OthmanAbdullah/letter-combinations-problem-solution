/**
 * PhoneNumber class contains a single static method "letterCombinations" that takes a String as an input and returns a List of Strings.
 * The input string represents a phone number, the output list represents all possible letter combinations that the given phone number can represent,
 * where each digit maps to a set of letters. The returned list is sorted in lexicographic order.
 *
 * @author (Abdullah Othman)
 * @version (1/15/2023)
 */

 package src;
 import java.util.ArrayList;
 import java.util.List;
 
 
 public class PhoneNumber {
     /**
      * This method takes a phone number as a string, and returns a list of all possible letter combinations that the phone number can represent.
      * Each digit maps to a set of letters. The returned list is sorted in lexicographic order.
      * @param digits a string representation of the phone number.
      * @return a list of all possible letter combinations that the phone number can represent.
      */
     public static List<String> letterCombinations(String digits) {
         if (digits.length() == 0)
             return new ArrayList<>();
         String[] phoneNumberMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; // the digit is  the  corrosponding  index
         List<String> allPossibleLetterCombinations = new ArrayList<>();
         backtrack("", 0, digits, allPossibleLetterCombinations, phoneNumberMap);
         return allPossibleLetterCombinations;
     }
 
     /**
      * A helper function that uses recursion to generate all possible letter combinations.
      *
      * @param combination  The current combination of letters
      * @param nextDigitIdx  The next index of the digit to process
      * @param digits  The  digits to process
      * @param result  A list to store the final letter combinations
      * @param phoneNumberMap  A mapping of digits to letters
      */
     private static void backtrack(String combination, int nextDigitIdx, String digits, List<String> result,
             String[] phoneNumberMap) {
         if (digits.length() == nextDigitIdx) { // stopping condition of the recursion.
             result.add(combination);
             return;
         }
         String letters = phoneNumberMap[digits.charAt(nextDigitIdx) - '0'];
         for (int i = 0; i < letters.length(); i++) {
             char letter = letters.charAt(i);
             backtrack(combination + letter, nextDigitIdx + 1, digits, result, phoneNumberMap);
         }
     }
 
     /**
      * This method sorts a List of Strings in lexicographic order.
      *
      * @param list a List of Strings to sort
      */
     // Note: the following funciton is not used because the letterCombination function produces the result in lexicographic order.
     // However, it could be used in case sorting is needed, such as going with a brute-force way.  
     public static void insertionSort(List<String> list) {
         for (int i = 1; i < list.size(); i++) {
             String current = list.get(i);
             int j = i - 1;
             while (j >= 0 && list.get(j).compareTo(current) > 0) {
                 list.set(j + 1, list.get(j));
                 j--;
             }
             list.set(j + 1, current);
         }
     }
 
     public static void main(String[] args) {
         System.out.println(letterCombinations("23"));
     }
 }
 