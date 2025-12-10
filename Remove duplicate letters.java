// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is

// among all possible results.

 

// Example 1:

// Input: s = "bcabc"
// Output: "abc"

// Example 2:

// Input: s = "cbacdcbc"
// Output: "acdb"

import java.io.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (used[idx]) continue;
            while (sb.length() > 0 &&
                   c < sb.charAt(sb.length() - 1) &&
                   last[sb.charAt(sb.length() - 1) - 'a'] > i) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            used[idx] = true;
        }
        return sb.toString();
    }

    // main reads one line from stdin and prints the result.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) return;
        System.out.println(new Solution().removeDuplicateLetters(s.trim()));
    }
}
