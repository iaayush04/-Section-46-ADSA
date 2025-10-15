// Given two integer arrays nums1 and nums2, return an array of their

// . Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
   List<Integer> lt= new ArrayList<>();
   for(int i = 0 ; i < nums1.length; i++){
for (int j =  0 ; j < nums2.length;j++){
    if (nums1 [i] == nums2 [j]){
        if(!lt.contains(nums1[i])){
            lt.add(nums1[i]);
        }
    }
}
   }     
   int arr[]=new int[lt.size()];
   for(int i=0;i<lt.size();i++){
arr[i]=lt.get(i);
   }
   return arr;
    }
}
