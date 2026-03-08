// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

// Example 1:

// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.

// Example 2:

// Input: nums = ["00","01"]
// Output: "11"
// Explanation: "11" does not appear in nums. "10" would also be correct.

// Example 3:

// Input: nums = ["111","011","001"]
// Output: "101"

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0') {
                res.append('1');
            } else {
                res.append('0');
            }
        }
        
        return res.toString();
    }
}
