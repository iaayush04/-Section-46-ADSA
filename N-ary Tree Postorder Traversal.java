// Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

// Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 

// Example 1:

// Input: root = [1,null,3,2,4,null,5,6]
// Output: [5,6,3,2,4,1]

// Example 2:

// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
// Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

import java.util.*;

// Standalone program: defines Node and demonstrates postorder traversal.
public class Main {
    // Definition for a Node (only define this once when running locally).
    static class Node {
        public int val;
        public List<Node> children;
        public Node() { children = new ArrayList<>(); }
        public Node(int val) { this.val = val; children = new ArrayList<>(); }
        public Node(int val, List<Node> children) { this.val = val; this.children = children; }
    }

    static class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            postorderHelper(root, result);
            return result;
        }

        private void postorderHelper(Node node, List<Integer> result) {
            if (node == null) return;
            if (node.children != null) {
                for (Node child : node.children) {
                    postorderHelper(child, result);
                }
            }
            result.add(node.val);
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Build sample tree: [1,null,3,2,4,null,5,6]
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3, Arrays.asList(n5, n6));
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node root = new Node(1, Arrays.asList(n3, n2, n4));

        Solution sol = new Solution();
        List<Integer> out = sol.postorder(root);
        System.out.println(out); // prints [5, 6, 3, 2, 4, 1]
    }
}
