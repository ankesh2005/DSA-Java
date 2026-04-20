package DepthSearchFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
  // lc-399. Evaluate Division
  class Solution {
    class Pair {
      String s;
      double val;

      Pair(String s, double val) {
        this.s = s;
        this.val = val;
      }
    }

    void dfs(String src, String des, double[] res, double product, Map<String, List<Pair>> adj, Set<String> vis) {
      if (vis.contains(src))
        return;
      vis.add(src);
      if (src.equals(des)) {
        res[0] = product;
      }
      for (Pair eqn : adj.get(src)) {
        String v = eqn.s;
        double val = eqn.val;
        dfs(v, des, res, product * val, adj, vis);
      }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, List<Pair>> adj = new HashMap<>();
      int n = equations.size();
      for (int i = 0; i < n; i++) {
        List<String> equation = equations.get(i);
        String var1 = equation.get(0);
        String var2 = equation.get(1);
        double value = values[i];
        adj.putIfAbsent(var1, new ArrayList<>());
        adj.putIfAbsent(var2, new ArrayList<>());
        adj.get(var1).add(new Pair(var2, value));
        adj.get(var2).add(new Pair(var1, 1.0 / value));
      }
      int m = queries.size();
      double ans[] = new double[m];
      for (int i = 0; i < m; i++) {
        List<String> query = queries.get(i);
        String src = query.get(0);
        String des = query.get(1);
        if (!adj.containsKey(src) || !adj.containsKey(des)) {
          ans[i] = -1.0;
        } else {
          double res[] = new double[1];
          res[0] = -1.0;
          Set<String> visited = new HashSet<>();
          dfs(src, des, res, 1.0, adj, visited);
          ans[i] = res[0];
        }
      }
      return ans;

    }
  }
}
