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
