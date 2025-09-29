// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:

// Input: digits = ""
// Output: []

// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
import java.util.*;

class Solution {
    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(result, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
