package Graphs;

import java.util.PriorityQueue;

public class MinimumCostToConnectAllPoints {
  // lc-1584. Min Cost to Connect All Points
  class Triplet implements Comparable<Triplet>{
    int point;
    int parent;
    int dist;
    public Triplet(int point,int parent,int dist){
        this.point=point;
        this.parent=parent;
        this.dist=dist;
    }
    @Override
    public int compareTo(Triplet t){
        return Integer.compare(this.dist,t.dist);
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        int cost=0;
        boolean visited[]=new boolean[points.length];
        while(!pq.isEmpty()){
            Triplet lowest=pq.poll();
            int point=lowest.point,parent=lowest.parent,dist=lowest.dist;
            if(visited[point])continue;
            visited[point]=true;
            cost+=dist;
            for(int i=0;i<points.length;i++){
                if(i==point)continue;
                int x1=points[point][0],y1=points[point][1];
                int x2=points[i][0],y2=points[i][1];
                int manhDist=Math.abs(x2-x1)+Math.abs(y2-y1);
                if(!visited[i])pq.add(new Triplet(i,point,manhDist));
            }
        }
        return cost;
    }
}
}
//dsu se kiya
class Solution {
    public int find(int i,int[] parent){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i],parent);
    }
    public void union(int u,int v,int[] parent,int size[]){
        int leaderU=find(u,parent);
        int leaderV=find(v,parent);
        if(leaderU!=leaderV){
            if(size[leaderU]>size[leaderV]){
                size[leaderU]+=1;
                parent[leaderV]=leaderU;
            }else{
                size[leaderV]++;
                parent[leaderU]=leaderV;
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int[] parent=new int[n];
        int[] size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        List<int[]> edges=new ArrayList<>();
        for(int u=0;u<n;u++){
            for(int v=u+1;v<n;v++){
                int x1=points[u][0];int y1=points[u][1];
                int x2=points[v][0];int y2=points[v][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                edges.add(new int[]{u,v,dist});
            }
        }
        Collections.sort(edges,(a,b)->{
            return Integer.compare(a[2],b[2]);
        });
        int cost=0;
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],dist=edge[2];
            if(find(u,parent)!=find(v,parent)){
                cost+=dist;
            }
            union(u,v,parent,size);
        }
        return cost;
    }
}