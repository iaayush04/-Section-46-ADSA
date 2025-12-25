// You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:

//     Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
//     The cost of the swap is min(basket1[i], basket2[j]).

// Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.

// Return the minimum cost to make both the baskets equal or -1 if impossible.

 

// Example 1:

// Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
// Output: 1
// Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.

// Example 2:

// Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
// Output: -1

import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : basket1) freq.put(x, freq.getOrDefault(x, 0) + 1);
        for (int x : basket2) freq.put(x, freq.getOrDefault(x, 0) + 1);

        for (int c : freq.values()) {
            if (c % 2 != 0) return -1;
        }

        Map<Integer, Integer> f1 = new HashMap<>();
        Map<Integer, Integer> f2 = new HashMap<>();

        for (int x : basket1) f1.put(x, f1.getOrDefault(x, 0) + 1);
        for (int x : basket2) f2.put(x, f2.getOrDefault(x, 0) + 1);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int x : freq.keySet()) {
            int diff = f1.getOrDefault(x, 0) - f2.getOrDefault(x, 0);
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) a.add(x);
            } else if (diff < 0) {
                for (int i = 0; i < (-diff) / 2; i++) b.add(x);
            }
        }

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        int minVal = Integer.MAX_VALUE;
        for (int x : basket1) minVal = Math.min(minVal, x);
        for (int x : basket2) minVal = Math.min(minVal, x);

        long res = 0;
        for (int i = 0; i < a.size(); i++) {
            res += Math.min(Math.min(a.get(i), b.get(i)), 2L * minVal);
        }

        return res;
    }
}


// Explanation: It can be shown that it is impossible to make both the baskets equal.
