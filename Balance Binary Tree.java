// Given a binary tree, determine if it is

// .

 

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: true

// Example 2:

// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false

// Example 3:

// Input: root = []
// Output: true

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // left subtree not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // current node not balanced

        return Math.max(leftHeight, rightHeight) + 1; // return height
    }
}

