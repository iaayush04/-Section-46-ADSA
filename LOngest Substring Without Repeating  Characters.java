// Given a string s, find the length of the longest

// without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0; // Handle empty string case
        }

        // Use a HashSet to store characters in the current window for O(1) average time lookup
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        // The right pointer iterates through the string, expanding the window
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If the current character is already in our set, it means we have a duplicate
            // within the current window [left, right). We need to shrink the window
            // from the left until the duplicate is removed.
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left)); // Remove the character at the left pointer
                left++; // Move the left pointer forward
            }

            // Now, the currentChar is unique within the new [left, right] window.
            // Add it to the set.
            charSet.add(currentChar);

            // Update the maximum length found so far.
            // The length of the current valid window is (right - left + 1).
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
