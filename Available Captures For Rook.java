// You are given an 8 x 8 matrix representing a chessboard. There is exactly one white rook represented by 'R', some number of white bishops 'B', and some number of black pawns 'p'. Empty squares are represented by '.'.

// A rook can move any number of squares horizontally or vertically (up, down, left, right) until it reaches another piece or the edge of the board. A rook is attacking a pawn if it can move to the pawn's square in one move.

// Note: A rook cannot move through other pieces, such as bishops or pawns. This means a rook cannot attack a pawn if there is another piece blocking the path.

// Return the number of pawns the white rook is attacking.

 

// Example 1:

// Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]

// Output: 3

// Explanation:

// In this example, the rook is attacking all the pawns.

// Example 2:

// Input: board = [[".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]

// Output: 0

// Explanation:

// The bishops are blocking the rook from attacking any of the pawns.

// Example 3:

// Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]

// Output: 3

// Explanation:

// The rook is attacking the pawns at positions b5, d6, and f5

class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = 0, rookCol = 0;

        // Step 1: Find the position of the Rook
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        int captures = 0;

        // Step 2: Check four directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int r = rookRow + dir[0];
            int c = rookCol + dir[1];

            // Move in one direction until blocked or out of bounds
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == 'B') break;  // bishop blocks path
                if (board[r][c] == 'p') {       // found a pawn to capture
                    captures++;
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }

        return captures;
    }
}
