// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

//     For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

 

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.

// Example 2:

// Input: x = 8
// Output: 2

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1, right = x, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;

            if (sq == x) return (int) mid;
            if (sq < x) {
                ans = (int) mid;
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return ans;
    }
}
