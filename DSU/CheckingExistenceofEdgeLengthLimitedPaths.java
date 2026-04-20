package DSU;

import java.util.Arrays;

public class CheckingExistenceofEdgeLengthLimitedPaths {
  // lc-1697. Checking Existence of Edge Length Limited Paths
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

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
      int m = queries.length;
      int s = edgeList.length;
      Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
      int[][] queriesWithIdx = new int[m][4];
      for (int i = 0; i < m; i++) {
        int u = queries[i][0];
        int v = queries[i][1];
        int thresh = queries[i][2];
        int idx = i;
        queriesWithIdx[i][0] = u;
        queriesWithIdx[i][1] = v;
        queriesWithIdx[i][2] = thresh;
        queriesWithIdx[i][3] = idx;
      }
      Arrays.sort(queriesWithIdx, (a, b) -> a[2] - b[2]);
      boolean ans[] = new boolean[m];
      int parent[] = new int[n];
      int rank[] = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
      int i = 0, j = 0;
      while (j < m) {
        int[] querie = queriesWithIdx[j];
        int src = querie[0];
        int des = querie[1];
        int thresh = querie[2];
        int idx = querie[3];
        while (i < s && thresh > edgeList[i][2]) {
          int u = edgeList[i][0];
          int v = edgeList[i][1];
          union(u, v, parent, rank);
          i++;
        }
        if (find(src, parent) != find(des, parent)) {
          ans[idx] = false;
        } else
          ans[idx] = true;
        j++;
      }
      return ans;
    }
  }
}
