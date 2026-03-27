package Graphs;

import java.util.Arrays;

public class BellManFordAlgorithm {
  class Solution {
    public int bellManFordAlgorithm(int[][] times, int n, int k) {
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for(int i=0;i<n-1;i++){
            for(int[] time:times){
                int u=time[0]; 
                int v=time[1];
                int w=time[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;

    }
}
}
