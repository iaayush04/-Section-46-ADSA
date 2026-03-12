// You are given an integer n, representing n nodes numbered from 0 to n - 1 and a list of edges, where edges[i] = [ui, vi, si, musti]:

//     ui and vi indicates an undirected edge between nodes ui and vi.
//     si is the strength of the edge.
//     musti is an integer (0 or 1). If musti == 1, the edge must be included in the spanning tree. These edges cannot be upgraded.

// You are also given an integer k, the maximum number of upgrades you can perform. Each upgrade doubles the strength of an edge, and each eligible edge (with musti == 0) can be upgraded at most once.

// The stability of a spanning tree is defined as the minimum strength score among all edges included in it.

// Return the maximum possible stability of any valid spanning tree. If it is impossible to connect all nodes, return -1.

// Note: A spanning tree of a graph with n nodes is a subset of the edges that connects all nodes together (i.e. the graph is connected) without forming any cycles, and uses exactly n - 1 edges.

 

// Example 1:

// Input: n = 3, edges = [[0,1,2,1],[1,2,3,0]], k = 1

// Output: 2

// Explanation:

//     Edge [0,1] with strength = 2 must be included in the spanning tree.
//     Edge [1,2] is optional and can be upgraded from 3 to 6 using one upgrade.
//     The resulting spanning tree includes these two edges with strengths 2 and 6.
//     The minimum strength in the spanning tree is 2, which is the maximum possible stability.

// Example 2:

// Input: n = 3, edges = [[0,1,4,0],[1,2,3,0],[0,2,1,0]], k = 2

// Output: 6

// Explanation:

//     Since all edges are optional and up to k = 2 upgrades are allowed.
//     Upgrade edges [0,1] from 4 to 8 and [1,2] from 3 to 6.
//     The resulting spanning tree includes these two edges with strengths 8 and 6.
//     The minimum strength in the tree is 6, which is the maximum possible stability.

// Example 3:

// Input: n = 3, edges = [[0,1,1,1],[1,2,1,1],[2,0,1,1]], k = 0



import java.util.*;

class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int left = 0, right = 0;

        for (int[] e : edges)
            right = Math.max(right, e[2] * 2);

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int used = 0;

        List<int[]> normal = new ArrayList<>();
        List<int[]> upgrade = new ArrayList<>();

        for (int[] e : edges) {

            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {

                if (s < target) return false;

                if (!dsu.union(u, v)) return false;

                used++;
            } 
            else {

                if (s >= target) normal.add(e);
                else if (2 * s >= target) upgrade.add(e);
            }
        }

        for (int[] e : normal) {
            if (dsu.union(e[0], e[1])) used++;
        }

        for (int[] e : upgrade) {
            if (k == 0) break;
            if (dsu.union(e[0], e[1])) {
                used++;
                k--;
            }
        }

        return used == n - 1;
    }
}

// Output: -1
