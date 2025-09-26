// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head node. This simplifies edge cases, like an empty result list,
        // as we can always return dummyHead.next.
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead; // Pointer to the current node in the result list
        int carry = 0; // Variable to store the carry-over digit

        // Loop while there are still digits in either list or a carry is present
        while (l1 != null || l2 != null || carry != 0) {
            // Get the value of the current node from l1. If l1 is null, treat as 0.
            int val1 = (l1 != null) ? l1.val : 0;
            // Get the value of the current node from l2. If l2 is null, treat as 0.
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum of the current digits and the carry
            int sum = val1 + val2 + carry;

            // Determine the new carry for the next step
            carry = sum / 10;

            // The digit for the current position in the result list is sum % 10
            current.next = new ListNode(sum % 10);
            current = current.next; // Move the current pointer to the newly created node

            // Move to the next nodes in l1 and l2, if they exist
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // The result list starts from the node after the dummy head
        return dummyHead.next;
    }
}



 
