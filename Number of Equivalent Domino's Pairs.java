// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

// Example 1:

// Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
// Output: 1

// Example 2:

// Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
// Output: 3


import java.util.*;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // since a,b <= 9, key = min*10+max <= 99
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            result += count[key];  // every previous domino with same key forms a pair
            count[key]++;
        }

        return result;
    }
}
