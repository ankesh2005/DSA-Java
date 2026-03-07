package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleDetectionUndirected {
  class Pair{
    int v;
    int p;
    Pair(int v,int p){
        this.v=v;
        this.p=p;
    }
}
class Solution {
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] visit,int s){
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(s,-1));
        visit[s]=true;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            for(int ver:adj.get(curr.v)){
                if(visit[ver]==false){
                    visit[ver]=true;
                    q.add(new Pair(ver,curr.v));
                }
                else if(ver!=curr.p){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,boolean[]visit,int node,int parent){
      visit[node]=true;
      for(int ver:adj.get(node)){
        if(!visit[ver])dfs(adj, visit, ver, node);
        else if(ver!=parent)return true;
      }
      return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        boolean visit[]=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] temp:edges){
          int a=temp[0];
          int b=temp[1];
          adj.get(a).add(b);
          adj.get(b).add(a);
        }
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                // if (bfs(adj, visit, i)) return true;
                if (dfs(adj, visit, i,-1)) return true;
            }
        }
        return false;

    }
    
}
}
