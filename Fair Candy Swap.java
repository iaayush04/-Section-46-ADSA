// Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

// Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

// Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

 

// Example 1:

// Input: aliceSizes = [1,1], bobSizes = [2,2]
// Output: [1,2]

// Example 2:

// Input: aliceSizes = [1,2], bobSizes = [2,3]
// Output: [1,2]

// Example 3:

// Input: aliceSizes = [2], bobSizes = [1,3]
// Output: [2,3]

import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0, sumBob = 0;
        for (int a : aliceSizes) sumAlice += a;
        for (int b : bobSizes) sumBob += b;

        // The difference that needs to be adjusted
        int diff = (sumAlice - sumBob) / 2;

        // Use a set for quick lookup
        Set<Integer> setAlice = new HashSet<>();
        for (int a : aliceSizes) setAlice.add(a);

        // Find the pair
        for (int b : bobSizes) {
            int a = b + diff;
            if (setAlice.contains(a)) {
                return new int[]{a, b};
            }
        }

        // Guaranteed to exist, so this line won't actually execute
        return new int[0];
    }
}

