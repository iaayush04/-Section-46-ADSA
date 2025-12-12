// Given a string s which consists of lowercase or uppercase letters, return the length of the longest

//  that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int c = 0; c < count.length; c++) {
            int cnt = count[c];
            if (cnt == 0) continue;
            if (cnt % 2 == 0) {
                length += cnt;
            } else {
                length += cnt - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) length += 1;
        return length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("abccccdd"));
        System.out.println(sol.longestPalindrome("a"));
    }
}

