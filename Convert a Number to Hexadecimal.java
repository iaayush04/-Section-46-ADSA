// Given a 32-bit integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

// All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

// Note: You are not allowed to use any built-in library method to directly solve this problem.

 

// Example 1:

// Input: num = 26
// Output: "1a"

// Example 2:

// Input: num = -1
// Output: "ffffffff"

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Process 32 bits → 8 hex digits max
        while (num != 0 && sb.length() < 8) {
            int hexDigit = num & 0xf;   // Take last 4 bits
            sb.append(map[hexDigit]);
            num >>>= 4;                 // Unsigned right shift
        }

        return sb.reverse().toString();
    }
}
