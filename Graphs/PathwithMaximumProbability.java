package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {
  //1514. Path with Maximum Probability
  class Pair implements Comparable<Pair> {
    int ver;
    double prob;

    Pair(int v, double p) {
        this.ver = v;
        this.prob = p;
    }

    public int compareTo(Pair t) {
        return Double.compare(this.prob, t.prob);
    }

}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] prob, int s, int e) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] temp = edges[i];
            int v = temp[1];
            int u = temp[0];
            double p = prob[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        double[] ans = new double[n];
        ans[s] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(s, 1));
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int u = node.ver;
            double pro = node.prob;
            if (pro < ans[u])
                continue;
            for (Pair present : adj.get(u)) {
                int v = present.ver;
                double p = present.prob;
                if (p * pro > ans[v]) {
                    pq.add(new Pair(v, p * pro));
                    ans[v] = p * pro;
                }
            }
        }
        return ans[e];

    }
}
}
