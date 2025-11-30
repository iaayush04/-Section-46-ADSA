Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [1]
Output: 1



class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = leftDepth(root);
        int rightHeight = rightDepth(root);

        // If heights are equal → perfect tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;   // 2^h - 1
        }

        // Otherwise, compute recursively
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDepth(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }

    private int rightDepth(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }
}
