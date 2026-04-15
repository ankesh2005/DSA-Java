package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {
  // lc-886. Possible Bipartition
  class Solution {
    boolean bfs(int n, int[][] dislikes) {
      int vis[] = new int[n + 1];
      Arrays.fill(vis, -1);

      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i <= n; i++)
        adj.add(new ArrayList<>());
      for (var dislike : dislikes) {
        int u = dislike[0];
        int v = dislike[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      for (int i = 1; i <= n; i++) {
        if (vis[i] == -1) {
          vis[i] = 0;
          Queue<Integer> q = new ArrayDeque<>();
          q.add(i);
          while (!q.isEmpty()) {
            int u = q.poll();
            int col = vis[u];
            for (int v : adj.get(u)) {
              if (vis[v] == -1) {
                vis[v] = 1 - col;
                q.add(v);
              } else if (vis[v] == vis[u])
                return false;
            }
          }
        }
      }

      return true;
    }

    boolean solve(int u, List<List<Integer>> adj, int[] vis, int color) {
      vis[u] = color;
      for (int v : adj.get(u)) {
        if (vis[v] == -1) {
          if (solve(v, adj, vis, 1 - vis[u]) == false)
            return false;
        } else if (vis[v] == vis[u]) {
          return false;
        }
      }
      return true;
    }

    boolean dfs(int n, int[][] dislikes) {
      int vis[] = new int[n + 1];
      Arrays.fill(vis, -1);// -1 unvisit 0-blue 1-red
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i <= n; i++)
        adj.add(new ArrayList<>());
      for (var dislike : dislikes) {
        int u = dislike[0];
        int v = dislike[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      for (int i = 1; i <= n; i++) {
        if (vis[i] == -1) {
          if (solve(i, adj, vis, 0) == false)
            return false;
        }
      }
      return true;
    }

    int find(int node, int[] parent, int[] parity) {
      if (parent[node] != node) {
        int origParent = parent[node];
        parent[node] = find(parent[node], parent, parity);
        parity[node] ^= parity[origParent]; // update parity during compression
      }
      return parent[node];
    }

    void union(int u, int v, int[] parent, int[] size, int[] parity) {
      int parentU = find(u, parent, parity);
      int parentV = find(v, parent, parity);
      if (parentU != parentV) {
        if (size[parentU] > size[parentV]) {
          size[parentU] += size[parentV];
          parent[parentV] = parentU;
          parity[parentV] = parity[u] ^ parity[v] ^ 1;
        } else {
          size[parentV] += size[parentU];
          parent[parentU] = parentV;
          parity[parentU] = parity[u] ^ parity[v] ^ 1;
        }
      }
    }

    boolean dsu(int n, int dislikes[][]) {
      int size[] = new int[n + 1];
      int parent[] = new int[n + 1];
      int parity[] = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        size[i] = 1;
        parent[i] = i;
        parity[i] = 0;
      }
      for (int[] dislike : dislikes) {
        int u = dislike[0];
        int v = dislike[1];
        if (u < v) {
          if (find(u, parent, parity) == find(v, parent, parity)) {
            if (parity[u] == parity[v])
              return false;// odd length cycle
          } else {
            union(u, v, parent, size, parity);
          }
        }
      }
      return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
      // return bfs(n,dislikes);
      // return dfs(n,dislikes);
      return dsu(n, dislikes);
    }
  }
}
