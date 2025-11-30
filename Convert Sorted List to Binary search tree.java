Given the head of a singly linked list where elements are sorted in ascending order, convert it to a

binary search tree.

 

Example 1:

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:

Input: head = []
Output: []

class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        // find middle
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);         // left half
        root.right = buildTree(slow.next, tail);   // right half

        return root;
    }
}
