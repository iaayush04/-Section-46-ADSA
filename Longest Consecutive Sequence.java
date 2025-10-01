// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

 

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Example 3:

// Input: nums = [1,0,1,2]
// Output: 3
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        for (int num : set) {
            // Only start from numbers that are the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int length = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                
                longest = Math.max(longest, length);
            }
        }
        
        return longest;
    }
}
