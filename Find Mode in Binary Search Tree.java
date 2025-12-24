// Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

// If the tree has more than one mode, return them in any order.

// Assume a BST is defined as follows:

//     The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//     Both the left and right subtrees must also be binary search trees.

 

// Example 1:

// Input: root = [1,null,2,2]
// Output: [2]

// Example 2:

// Input: root = [0]
// Output: [0]

import java.util.*;

class Solution {

    Integer prev = null;    
    int count = 0;          
    int maxCount = 0;        
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Frequency logic
        if (prev == null || node.val != prev) {
            count = 1;
        } else {
            count++;
        }

        // Update mode(s)
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }
}



