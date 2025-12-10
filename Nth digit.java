// Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

// Example 1:

// Input: n = 3
// Output: 3

// Example 2:

// Input: n = 11
// Output: 0
// Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


public class Solution {
    public int findNthDigit(int n) {
        long digits = 1, start = 1, count = 9, N = n;

        while (N > digits * count) {
            N -= digits * count;
            digits++;
            start *= 10;
            count *= 10;
        }

        long number = start + (N - 1) / digits;
        int index = (int)((N - 1) % digits);
        return Long.toString(number).charAt(index) - '0';
    }
}
