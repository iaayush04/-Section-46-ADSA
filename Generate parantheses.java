// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:

// Input: n = 1
// Output: ["()"]

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n) {
        // Base case: if the string is complete
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        // If we can still add an opening parenthesis
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // If we can add a closing parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}

