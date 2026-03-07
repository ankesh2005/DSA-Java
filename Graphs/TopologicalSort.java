package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class TopologicalSort {
  // dfs
  class Solution1 {
    public void dfs(int i,ArrayList<ArrayList<Integer>>adj,boolean[] visit,ArrayList<Integer>ans){
        visit[i]=true;
        for(int ver:adj.get(i)){
            if(!visit[ver]){
                dfs(ver,adj,visit,ans);
            }
        }
        ans.add(i);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean visit[]=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] temp:edges){
          int a=temp[0];
          int b=temp[1];
          adj.get(a).add(b);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visit[i])
            dfs(i,adj,visit,ans);
        }
        Collections.reverse(ans);
        return ans;
    }
}
// bfs kahn algo
class Solution2 {
    public void bfs(int[] indegree,ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans){
        Queue<Integer> q=new ArrayDeque<>();
        int n=indegree.length;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int curr=q.remove();
            ans.add(curr);
            for(int ver:adj.get(curr)){
                indegree[ver]--;
                if(indegree[ver]==0)q.add(ver);
            }
        }
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] indegree=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] temp:edges){
          int a=temp[0];
          int b=temp[1];
          indegree[b]++;
          adj.get(a).add(b);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        bfs(indegree,adj,ans);
        return ans;
    }
}
}
