// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
      int total_len = x + y;
      int totalLeftHalf = (total_len + 1)/2;
      int low = Math.max(0, totalLeftHalf - y);
        int high = Math.min(x, totalLeftHalf);
 while(low <= high) {
   int partitionX = low + (high - low) / 2;
    int partitionY = totalLeftHalf - partitionX;
int maxX_left = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX_right = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY_left = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY_right = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
    if (maxX_left <= minY_right && maxY_left <= minX_right) {
      if (total_len % 2 == 1) {
         return Math.max(maxX_left, maxY_left);
                } else {
        double leftMax = Math.max(maxX_left, maxY_left);
                    double rightMin = Math.min(minX_right, minY_right);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (maxX_left > minY_right) {
         high = partitionX - 1;
            } else { 
      low = partitionX + 1;
            }
        }

              throw new IllegalArgumentException("No median found. Invalid input or logic error.");
    }
}
