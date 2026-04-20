package DSU;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class NumberofGoodPaths {
  // lc-2421. Number of Good Paths
  class Solution {
    int find(int u, int[] parent) {
      if (u == parent[u])
        return u;
      return parent[u] = find(parent[u], parent);
    }

    void union(int u, int v, int[] parent, int[] size) {
      int leadU = find(u, parent);
      int leadV = find(v, parent);
      if (leadU != leadV) {
        if (size[leadU] > size[leadV]) {
          size[leadU] += size[leadV];
          parent[leadV] = leadU;
        } else {
          size[leadV] += size[leadU];
          parent[leadU] = leadV;
        }
      }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
      List<List<Integer>> adj = new ArrayList<>();
      int n = vals.length;
      for (int i = 0; i < n; i++)
        adj.add(new ArrayList<>());
      for (int edge[] : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
      }

      int[] parent = new int[n];
      int[] size = new int[n];
      boolean[] active = new boolean[n];
      for (int i = 0; i < n; i++) {
        size[i] = 1;
        parent[i] = i;
      }
      Map<Integer, List<Integer>> map = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        map.putIfAbsent(vals[i], new ArrayList<>());
        map.get(vals[i]).add(i);
      }
      int res = n;
      for (int key : map.keySet()) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int u : map.get(key)) {
          active[u] = true;
          q.add(u);
        }
        while (!q.isEmpty()) {
          int u = q.poll();
          for (int v : adj.get(u)) {
            if (find(u, parent) != find(v, parent) && active[v]) {
              union(u, v, parent, size);
            }
          }
        }
        List<Integer> parentsKaunHai = new ArrayList<>();
        for (int u : map.get(key)) {
          parentsKaunHai.add(find(u, parent));
        }
        Collections.sort(parentsKaunHai);
        int sz = parentsKaunHai.size();
        for (int j = 0; j < sz; j++) {
          int count = 0;
          int parentFixed = parentsKaunHai.get(j);
          while (j < sz && parentFixed == parentsKaunHai.get(j)) {
            j++;
            count++;
          }
          j--;
          int formula = count * (count - 1) / 2;
          res += formula;
        }
      }
      return res;
    }
  }
}
