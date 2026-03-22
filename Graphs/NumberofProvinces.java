package Graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces {
  // lc-547. Number of Provinces
   public int findCircleNum(int[][] grid) {
        int n=grid.length;
        HashSet<Integer> unvisit=new HashSet<>();
        for(int i=0;i<n;i++)unvisit.add(i);
        int count=0;
        Queue<Integer>q=new ArrayDeque<>();
        while(!unvisit.isEmpty()){
            int city=unvisit.iterator().next();
            q.add(city);
            unvisit.remove(city);
            count++;
            while(!q.isEmpty()){
                int cty=q.remove();
                for(int i=0;i<n;i++){
                    if(grid[cty][i]==1 && unvisit.contains(i)){
                        q.add(i);
                        unvisit.remove(i);
                    }
                }
            }
        }
        return count;
    }
    public int find(int[][] grid,int v){
      boolean[] visit=new boolean[v];
      int count=0;
      for(int i=0;i<v;i++){
        if(visit[i]==false){
          bfs(grid,i,visit);
          // dfs(grid,visit,i);
          count++;
        }
      }
      return count;
    }
    public void bfs(int[][] grid,int city,boolean[] visit){
      Queue<Integer> q=new LinkedList<>();
      visit[city]=true;
      q.add(city);
      while(q.size()>0){
        int cty=q.remove();
        for(int i=0;i<visit.length;i++){
          if(grid[cty][i]==1 && visit[i]==false){
            q.add(i);
            visit[i]=true;
          }
        }
      }
    }
    public void dfs(int[][] grid,boolean[]visit,int x){
        for(int i=0;i<visit.length;i++){
            if(grid[x][i]==1 && !visit[i]){
                visit[i]=true;
                dfs(grid,visit,i);
            }
        }
    }

    // disjoint set union
    class Solution {
    public int find(int u,int[] parent){
        if(parent[u]==u)return u;
        return find(parent[u],parent);
    }
    public void union(int u,int v,int[] parent){
        int parentU=find(u,parent);
        int parentV=find(v,parent);
        if(parentU!=parentV){
            parent[parentU]=parentV;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++)parent[i]=i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i+1,j+1,parent);
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i)ans++;
        }
        return ans;

    }
}
}
