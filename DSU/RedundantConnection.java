package DSU;

public class RedundantConnection {
  // lc-684. Redundant Connection 
  class Solution {
    public int find(int u, int[] parent) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u], parent);
    }

    public void union(int u, int v, int[] parent, int[] size) {
        u = find(u, parent);
        v = find(v, parent);
        if (u != v) {
            if (size[u] > size[v]) {
                parent[v] = u;
                size[u] += size[v];
            } else {
                parent[u] = v;
                size[v] += size[u];
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(u, parent) == find(v, parent))
                return edge;
            union(u, v, parent, size);
        }
        return new int[] { 0, 0 };
    }
}
}
