// You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

// Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.

 

// Example 1:

// Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
// Output: 4
// Explanation: You can rearrange the columns as shown above.
// The largest submatrix of 1s, in bold, has an area of 4.

// Example 2:

// Input: matrix = [[1,0,1,0,1]]
// Output: 3
// Explanation: You can rearrange the columns as shown above.
// The largest submatrix of 1s, in bold, has an area of 3.

// Example 3:

// Input: matrix = [[1,1,0],[1,0,1]]
// Output: 2

import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) height[j] = 0;
                else height[j]++;
            }

            int[] temp = height.clone();
            Arrays.sort(temp);

            for (int j = 0; j < n; j++) {
                int h = temp[n - 1 - j];
                max = Math.max(max, h * (j + 1));
            }
        }
        return max;
    }
}
