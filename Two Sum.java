// #Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]







import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store number -> index
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // If found, return the indices
                return new int[] { numMap.get(complement), i };
            }

            // Otherwise, add the current number and its index to the map
            numMap.put(num, i);
        }

        // According to the problem statement, there will always be exactly one solution,
        // so this line should theoretically not be reached.
        // It's included for completeness in case of unexpected input.
        throw new IllegalArgumentException("No two sum solution");
    }
}

