package DepthSearchFirst;

import java.util.Arrays;

public class LongestCycleinaGraph {
  // lc-2360. Longest Cycle in a Graph
  class Solution {
    int dfs(boolean[] vis,boolean[] rec,int[] len,int[] edges,int u){
        int size=-1;
        vis[u]=true;
        rec[u]=true;
        int v=edges[u];
        if(v!=-1 && !vis[v]){
            len[v]=len[u]+1;
            size=dfs(vis,rec,len,edges,v);
        }
        else if(v!=-1 && rec[v]){
            rec[u]=false;
            return len[u]-len[v]+1;
        }
        rec[u]=false;
        return size;

    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean vis[]=new boolean[n];
        boolean rec[]=new boolean[n];
        int len[]=new int[n];
        Arrays.fill(len,1);
        int max=-1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int size=dfs(vis,rec,len,edges,i);
                max=Math.max(max,size);
            }
        }
        return max;
    }
}
}
