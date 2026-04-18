package DepthSearchFirst;

import java.util.ArrayList;
import java.util.List;

public class MinimumScoreofaPathBetweenTwoCities {
  // lc-2492. Minimum Score of a Path Between Two Cities
  class Solution {
    int min;
    void dfs(List<List<int[]>>adj,int u,boolean[] vis){
        vis[u]=true;
        for(int[] road:adj.get(u)){
            int v=road[0];
            int dis=road[1];
            min=Math.min(dis,min);
            if(!vis[v])dfs(adj,v,vis);
        }
    }
    
    public int minScore(int n, int[][] roads) {
        min=Integer.MAX_VALUE;
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int dis=road[2];
            adj.get(u).add(new int[]{v,dis});
            adj.get(v).add(new int[]{u,dis});
        }
        dfs(adj,1,new boolean[n+1]);
        return min;
    }
}
}
