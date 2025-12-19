// Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v.

// Your task is to return a list of all connected components. Each connected component should be represented as a list of its vertices, with all components returned in a collection where each component is listed separately.

// Note: You can return the components in any order, driver code will print the components in sorted order.

// Examples :

// Input: V = 5, edges[][] = [[0, 1], [2, 1], [3, 4]]
// Output: [[0, 1, 2], [3, 4]]
// Explanation:

// Input: V = 7, edges[][] = [[0, 1], [6, 0], [2, 4], [2, 3], [3, 4]]
// Output: [[0, 1, 6], [2, 3, 4], [5]]



import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, adj, visited, comp);
                res.add(comp);
            }
        }

        return res;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj,
             boolean[] visited, ArrayList<Integer> comp) {
        visited[node] = true;
        comp.add(node);
        for (int n : adj.get(node)) {
            if (!visited[n]) dfs(n, adj, visited, comp);
        }
    }
}
