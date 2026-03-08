package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  // 743. Network Delay Time
  class Pair{
    int v;
    int w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)adj.add(new ArrayList<>());
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            adj.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.w-b.w);
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair node=pq.poll();
            int u=node.v;
            int dis=node.w;
            if(dis>dist[u])continue;
            for(Pair p:adj.get(u)){
                int v=p.v;
                int w=p.w;
                if(dis+w<dist[v]){
                    dist[v]=dis+w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<n+1;i++){
            ans=Math.max(ans,dist[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
}
