package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueinaDirectedGraph {
  // lc-1857. Largest Color Value in a Directed Graph
  class Solution {
    public int largestPathValue(String colors, int[][] edges) {
      int n = colors.length();
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<>());
      int[] indegree = new int[n];
      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj.get(u).add(v);
        indegree[v]++;
      }
      Queue<Integer> q = new ArrayDeque<>();
      int[][] dp = new int[n][26];
      for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
          q.add(i);
          dp[i][colors.charAt(i) - 'a'] = 1;
        }
      }
      int countNodes = 0;// to detect cycle
      int ans = 1;
      while (!q.isEmpty()) {
        int u = q.poll();
        countNodes++;
        for (int v : adj.get(u)) {
          for (int i = 0; i < 26; i++) {
            dp[v][i] = Math.max(dp[v][i], dp[u][i] + ((colors.charAt(v) - 'a' == i) ? 1 : 0));
            ans = Math.max(dp[v][i], ans);
          }
          indegree[v]--;
          if (indegree[v] == 0) {
            q.add(v);
          }
        }
      }
      return countNodes < n ? -1 : ans;

    }
  }
}
