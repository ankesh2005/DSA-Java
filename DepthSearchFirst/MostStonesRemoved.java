package DepthSearchFirst;

public class MostStonesRemoved {
  // lc-947. Most Stones Removed with Same Row or Column
  class Solution {
    public void dfs(int[][] stones, int idx, boolean[] vis) {
        vis[idx] = true;
        for (int i = 0; i < vis.length; i++) {
            int r = stones[idx][0];
            int c = stones[idx][1];
            if (!vis[i] && (stones[i][0] == r || stones[i][1] == c)) {
                dfs(stones, i, vis);
            }

        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == true)
                continue;
            dfs(stones, i, vis);
            groups++;
        }
        return n - groups;
    }
}
}
