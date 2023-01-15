package src;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        String[] phoneNumberMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; // the digit is  the  corrosponding  index
        List<String> allPossibleLetterCombinations = new ArrayList<>();
        backtrack("", 0, digits, allPossibleLetterCombinations, phoneNumberMap);
        return allPossibleLetterCombinations;
    }

    private static void backtrack(String combination, int nextDigitIdx, String next_digits, List<String> result,
            String[] phone_number_map) {
        if (next_digits.length() == nextDigitIdx) { // stopping condition of the recursion.
            result.add(combination);
            return;
        }
        String letters = phone_number_map[next_digits.charAt(nextDigitIdx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            backtrack(combination + letter, nextDigitIdx + 1, next_digits, result, phone_number_map);
        }
    }
    
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
