// you are given a stack st[]. You have to reverse the stack.

// Examples:

// Input: st[] = [1, 2, 3, 4]
// Output: [1, 2, 3, 4]
// Explanation: After reversing, the elements of stack are in opposite order.

// Input: st[] = [3, 2, 1]
// Output: [3, 2, 1]
// Explanation: After reversing, the elements of stack are in opposite order.

// Constraints:
// 1 ≤ st.size() ≤ 100
// 0 ≤ stack element ≤ 100



// help me to solve this problem step by step in java 

import java.util.*;

class Solution {

    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    private void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }
        int top = st.pop();
        insertAtBottom(st, val);
        st.push(top);
    }
}
