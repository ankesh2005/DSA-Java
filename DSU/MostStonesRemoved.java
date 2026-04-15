package DSU;

public class MostStonesRemoved {
  // lc-947. Most Stones Removed with Same Row or Column
  class Solution {
    public int find(int u, int parent[]) {
      if (parent[u] != u) {
        parent[u] = find(parent[u], parent);
      }
      return parent[u];
    }

    public void union(int u, int v, int[] parent, int[] size) {
      int parentU = find(u, parent);
      int parentV = find(v, parent);
      if (parentU != parentV) {
        if (size[parentU] > size[parentV]) {
          parent[parentV] = parentU;
          size[parentU] += size[parentV];
        } else {
          parent[parentU] = parentV;
          size[parentV] += size[parentU];
        }
      }
    }

    public int removeStones(int[][] stones) {
      int n = stones.length;
      int[] parent = new int[n];
      int size[] = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
      for (int i = 0; i < n; i++) {
        int r = stones[i][0];
        int c = stones[i][1];
        for (int j = i + 1; j < n; j++) {
          if (stones[j][0] == r || stones[j][1] == c) {
            union(i, j, parent, size);
          }
        }
      }
      int groups = 0;
      for (int i = 0; i < n; i++) {
        if (parent[i] == i) {
          groups++;
        }
      }
      return n - groups;

    }
  }
}
