// Reverse bits of a given 32 bits signed integer.

 

// Example 1:

// Input: n = 43261596

// Output: 964176192

// Explanation:
// Integer	Binary
// 43261596	00000010100101000001111010011100
// 964176192	00111001011110000010100101000000

// Example 2:

// Input: n = 2147483644

// Output: 1073741822

public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;         // make space for next bit
            rev |= (n & 1);    // add LSB of n to rev
            n >>>= 1;          // unsigned shift n
        }
        return rev;
    }

    // quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseBits(43261596));   // prints 964176192
        System.out.println(s.reverseBits(2147483644)); // prints 1073741822
    }
}
