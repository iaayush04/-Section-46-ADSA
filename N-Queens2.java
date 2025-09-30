// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:

// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

// Example 2:

// Input: n = 1
// Output: 1

class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        // Track attacked columns and diagonals
        boolean[] cols = new boolean[n];            // columns
        boolean[] diag1 = new boolean[2 * n];       // main diagonals (r - c)
        boolean[] diag2 = new boolean[2 * n];       // anti-diagonals (r + c)

        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++; // placed all queens safely → one valid solution
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n; // shift index to avoid negatives
            int d2 = row + col;

            // skip if position is under attack
            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            // place queen
            cols[col] = diag1[d1] = diag2[d2] = true;
            backtrack(row + 1, n, cols, diag1, diag2);
            // remove queen (backtrack)
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}
