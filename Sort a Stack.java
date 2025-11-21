// Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

// Examples:

// Input: st[] = [1, 2, 3]
// Output: [3, 2, 1]
// Explanation: The stack is already sorted in ascending order.

// Input: st[] = [41, 3, 32, 2, 11]
// Output: [41, 32, 11, 3, 2]
// Explanation: After sorting, the smallest element (2) is at the bottom and the largest element (41) is at the top.

import java.util.*;

class Solution {

    public Stack<Integer> sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int top = st.pop();
            sortStack(st);       // recursively sort remaining stack
            insertSorted(st, top);
        }
        return st;
    }

    private void insertSorted(Stack<Integer> st, int x) {
        // If stack is empty OR top element <= x → push directly
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }

        int temp = st.pop();
        insertSorted(st, x);
        st.push(temp);
    }
}

