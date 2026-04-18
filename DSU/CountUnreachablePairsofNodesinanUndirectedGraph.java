package DSU;

import java.util.ArrayList;
import java.util.List;

public class CountUnreachablePairsofNodesinanUndirectedGraph {
  // lc-2316. Count Unreachable Pairs of Nodes in an Undirected Graph
  class Solution {
    public int find(int u, int[] parent) {
      if (parent[u] == u)
        return u;
      return parent[u] = find(parent[u], parent);
    }

    public void union(int u, int v, int[] parent, int size[]) {
      int leadU = find(u, parent);
      int leadV = find(v, parent);
      if (leadU != leadV) {
        if (size[leadU] > size[leadV]) {
          parent[leadV] = leadU;
          size[leadU] += size[leadV];
        } else {
          parent[leadU] = leadV;
          size[leadV] += size[leadU];
        }
      }
    }

    public long countPairs(int n, int[][] edges) {
      int[] parent = new int[n];
      int size[] = new int[n];
      for (int i = 0; i < n; i++) {
        size[i] = 1;
        parent[i] = i;
      }
      for (int edge[] : edges) {
        int u = edge[0];
        int v = edge[1];
        union(u, v, parent, size);
      }
      List<Integer> components = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int lead = find(i, parent);
        if (lead == i) {
          components.add(size[i]);
        }
      }
      long total = 0;
      for (int val : components)
        total += val;
      long ans = 0;
      for (int val : components) {
        total -= val;
        ans += total * val;
      }
      return ans;
    }
  }

}