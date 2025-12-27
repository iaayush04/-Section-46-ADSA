// You are given two positive 0-indexed integer arrays nums1 and nums2, both of length n.

// The sum of squared difference of arrays nums1 and nums2 is defined as the sum of (nums1[i] - nums2[i])2 for each 0 <= i < n.

// You are also given two positive integers k1 and k2. You can modify any of the elements of nums1 by +1 or -1 at most k1 times. Similarly, you can modify any of the elements of nums2 by +1 or -1 at most k2 times.

// Return the minimum sum of squared difference after modifying array nums1 at most k1 times and modifying array nums2 at most k2 times.

// Note: You are allowed to modify the array elements to become negative integers.

 

// Example 1:

// Input: nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
// Output: 579
// Explanation: The elements in nums1 and nums2 cannot be modified because k1 = 0 and k2 = 0. 
// The sum of square difference will be: (1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2 = 579.

// Example 2:

// Input: nums1 = [1,4,10,12], nums2 = [5,8,6,9], k1 = 1, k2 = 1
// Output: 43


class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int maxD = 0;
        int[] freq = new int[100001];

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            maxD = Math.max(maxD, d);
        }

        for (int d = maxD; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            long move = Math.min(k, freq[d]);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }

        long ans = 0;
        for (int d = 0; d <= maxD; d++) {
            if (freq[d] > 0) {
                ans += (long) d * d * freq[d];
            }
        }

        return ans;
    }
}
