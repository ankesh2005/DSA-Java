package DepthSearchFirst;

import java.util.ArrayList;
import java.util.List;

public class NumberofNodesintheSubTreeWiththeSameLabel {
  // lc-1519. Number of Nodes in the Sub-Tree With the Same Label
  class Solution {
    public void dfs(int u, int parent, List<List<Integer>> graph, String labels, int[] count, int[] res) {
      int mylabel = labels.charAt(u);
      int countbeforeexplore = count[mylabel - 'a'];
      count[mylabel - 'a']++;
      for (int v : graph.get(u)) {
        if (v == parent)
          continue;
        dfs(v, u, graph, labels, count, res);
      }
      int countafterexplore = count[mylabel - 'a'];
      int nodeswithsamelabel = countafterexplore - countbeforeexplore;
      res[u] = nodeswithsamelabel;

    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {

      List<List<Integer>> graph = new ArrayList<>();
      for (int i = 0; i < n; i++)
        graph.add(new ArrayList<>());
      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      int[] count = new int[26];
      int[] res = new int[n];
      dfs(0, -1, graph, labels, count, res);
      return res;
    }
  }
}
