package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
  class Pair implements Comparable<Pair> {
    int node;
    int weight;

    Pair(int n, int w) {
      node = n;
      weight = w;
    }

    public int compareTo(Pair t) {
      return this.weight - t.weight;
    }
  }

  class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
      ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++)
        adj.add(new ArrayList<>());

      for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
      }
      int[] dist = new int[V];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[src] = 0;
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, 0));
      while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        int u = curr.node;
        int dis = curr.weight;
        if (dis > dist[u])
          continue;
        for (Pair p : adj.get(u)) {
          int v = p.node;
          int w = p.weight;
          if (dis + w < dist[v]) {
            dist[v] = dis + w;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
      return dist;
    }
  }
}
