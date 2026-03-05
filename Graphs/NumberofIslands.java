package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofIslands {
  // lc-200 number of islands
  class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void bfs(char[][] grid,boolean[][] visit,int x,int y){
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(x,y));
        while(!q.isEmpty()){
            Pair p=q.remove();
            int px=p.x;
            int py=p.y;
            // left
            if(px-1>=0 &&visit[px-1][py]==false&&grid[px-1][py]=='1'){
                visit[px-1][py]=true;
                q.add(new Pair(px-1,py));
            }
            // right
            if(px+1<grid.length &&visit[px+1][py]==false&&grid[px+1][py]=='1'){
                visit[px+1][py]=true;
                q.add(new Pair(px+1,py));
            }
            // up
            if(py-1>=0 &&visit[px][py-1]==false&&grid[px][py-1]=='1'){
                visit[px][py-1]=true;
                q.add(new Pair(px,py-1));
            }
            // down
            if(py+1<grid[0].length && visit[px][py+1]==false&&grid[px][py+1]=='1'){
                visit[px][py+1]=true;
                q.add(new Pair(px,py+1));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visit=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visit[i][j]==false){
                    ans++;
                    bfs(grid,visit,i,j);
                }
            }
        }
        return ans;
    }
}
}
