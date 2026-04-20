import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FindClosestNodetoGivenTwoNodes {
  // lc-2359. Find Closest Node to Given Two Nodes
  class Solution {
    public void dfs(int[] edges,int u,int[] dist,boolean[] vis){
        vis[u]=true;
        int v=edges[u];
        if(edges[u]!=-1 && !vis[v]){
            dist[v]=1+dist[u];
            dfs(edges,v,dist,vis);
        }
    }
    public void bfs(int[]edges,int[] dist,int u){
        int n=edges.length;
        boolean vis[]=new boolean[n];
        Queue<int[]>q=new ArrayDeque<>();
        vis[u]=true;
        q.add(new int[]{edges[u],u});
        while(!q.isEmpty()){
            int[] child_parent=q.poll();
            int v=child_parent[0];
            u=child_parent[1];
            if(v!=-1 && !vis[v]){
                vis[v]=true;
                dist[v]=1+dist[u];
                q.add(new int[]{edges[v],v});
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n];
        int[] dist2=new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist1[node1]=0;dist2[node2]=0;
        // dfs(edges,node1,dist1,new boolean[n]);
        // dfs(edges,node2,dist2,new boolean[n]);
        bfs(edges,dist1,node1);
        bfs(edges,dist2,node2);
        int minDistance=Integer.MAX_VALUE;
        int ans=-1;
        int maxbetweenboth=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int dis1=dist1[i];
            int dis2=dist2[i];
            maxbetweenboth=Math.max(dis1,dis2);
            if(minDistance>maxbetweenboth){
                minDistance=maxbetweenboth;
                ans=i;
            }
        }
        return ans;
    }
}
}
