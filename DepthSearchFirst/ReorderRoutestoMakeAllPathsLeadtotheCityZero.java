package DepthSearchFirst;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
  // lc-1466. Reorder Routes to Make All Paths Lead to the City Zero
  class Solution {
    int dfs(List<List<int[]>>adj,int u,boolean[] vis){
        int count=0;
        for(int[] conn:adj.get(u)){
            int v=conn[0];
            int flip=conn[1];
            if(vis[v])continue;
            count+=flip;
            vis[v]=true;
            count+=dfs(adj,v,vis);
        }
        return count;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        // 0->fake conn 1->orig conn
        for(int connection[]: connections){
            int u=connection[0];
            int v=connection[1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }
        boolean vis[]=new boolean[n];
        vis[0] = true;
        return dfs(adj,0,vis);
    }
}
}
