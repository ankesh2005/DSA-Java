package DSU;

import java.util.Arrays;

public class RemoveMaxNumberofEdgestoKeepGraphFullyTraversable {
  // lc-1579. Remove Max Number of Edges to Keep Graph Fully Traversable
  class Solution {
    public int find(int u, int[] parent) {
      if (parent[u] == u)
        return u;
      return parent[u] = find(parent[u], parent);
    }

    public void union(int u, int v, int[] parent, int[] rank) {
      int leadU = find(u, parent);
      int leadV = find(v, parent);
      if (leadU == leadV)
        return;
      if (rank[leadU] > rank[leadV]) {
        parent[leadV] = leadU;
      } else if (rank[leadV] > rank[leadU]) {
        parent[leadU] = leadV;
      } else {
        parent[leadV] = leadU;
        rank[leadU]++;
      }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
      int AliceParent[] = new int[n + 1];
      int AliceRank[] = new int[n + 1];
      int BobParent[] = new int[n + 1];
      int BobRank[] = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        AliceParent[i] = i;
        AliceRank[i] = 1;
        BobParent[i] = i;
        BobRank[i] = 1;
      }
      Arrays.sort(edges, (a, b) -> b[0] - a[0]);
      int ca = n;// components in alice
      int cb = n;// components in bob
      int edgesUsed = 0;
      for (int edge[] : edges) {
        int type = edge[0];
        int u = edge[1];
        int v = edge[2];
        if (type == 3) {
          if (find(u, AliceParent) != find(v, AliceParent)) {
            ca--;
            cb--;
            edgesUsed++;
            union(u, v, AliceParent, AliceRank);
            union(u, v, BobParent, BobRank);// since we connecting type 3 so both graph will identical
          }
        } else if (type == 1) {
          if (find(u, AliceParent) != find(v, AliceParent)) {
            ca--;
            edgesUsed++;
            union(u, v, AliceParent, AliceRank);
          }
        } else {
          if (find(u, BobParent) != find(v, BobParent)) {
            cb--;
            edgesUsed++;
            union(u, v, BobParent, BobRank);
          }
        }
      }
      if (ca == 1 && cb == 1)
        return edges.length - edgesUsed;
      else
        return -1;
    }
  }
}
