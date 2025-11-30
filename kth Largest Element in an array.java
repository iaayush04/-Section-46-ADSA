Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
import java.util.Random;

class Solution {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        while (true) {
            if (left == right) return nums[left];

            int pivotIndex = left + rand.nextInt(right - left + 1);
            pivotIndex = partition(nums, left, right, pivotIndex);

            if (pivotIndex == kSmallest)
                return nums[pivotIndex];
            else if (kSmallest < pivotIndex)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
