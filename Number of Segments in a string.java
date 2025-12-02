// Given a string s, return the number of segments in the string.

// A segment is defined to be a contiguous sequence of non-space characters.

 

// Example 1:

// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]

// Example 2:

// Input: s = "Hello"
// Output: 1

class Solution {
    public int countSegments(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
