package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
public class FindifPathExistsinGraph {
  // lc-1971 Find if Path Exists in Graph
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    boolean visit[]=new boolean[n];
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++)adj.add(new ArrayList<>());
    for(int[] temp:edges){
      int a=temp[0];
      int b=temp[1];
      adj.get(a).add(b);
      adj.get(b).add(a);
    }
    bfs(adj,source,visit,n);
    return visit[destination];
  }
  public void bfs(ArrayList<ArrayList<Integer>>adj,int src,boolean visit[],int n){
    Queue<Integer> q=new ArrayDeque<>();
    q.add(src);
    visit[src]=true;
    while (q.size()>0) {
      int front=q.remove();
      for(int x:adj.get(front)){
        if(!visit[x]){
          q.add(x);
          visit[x]=true;
        }
      }
    }

  }
}
