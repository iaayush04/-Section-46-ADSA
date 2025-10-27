// Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

 

// Example 1:

// Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
// Output: true
// Explanation:
// In the above grid, the diagonals are:
// "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
// In each diagonal all elements are the same, so the answer is True.

// Example 2:

// Input: matrix = [[1,2],[2,2]]
// Output: false

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Start checking from 1,1 (second row, second column)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Each element must be equal to top-left diagonal element
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
