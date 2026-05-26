package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
  // lc-1091. Shortest Path in Binary Matrix
    int[][] dirs={{-1,0},{-1,-1},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int bfs(int[][] grid){
        Queue<int[]> q=new ArrayDeque<>();
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        q.add(new int[]{0,0});
        grid[0][0]=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cords[]=q.poll();
            if(cords[0]==m-1 && cords[1]==n-1)return count+1;
            for(int[] dir:dirs){
                int row=cords[0]+dir[0];
                int col=cords[1]+dir[1];
                if(row<0 || row>=m || col<0 || col>=n)continue;
                else if(grid[row][col]!=1){
                    grid[row][col]=1;
                    q.add(new int[]{row,col});
                }
            }
            }
            count++;
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        // bfs(grid);
        //dijkisra
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        int[][] dij=new int[m][n];
        for(int[] row:dij)Arrays.fill(row,Integer.MAX_VALUE);
        dij[0][0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //distance, x, y
        pq.add(new int[]{1,0,0});
        grid[0][0]=1;
        while(!pq.isEmpty()){
            int[] dis_node=pq.poll();
            int dis=dis_node[0];
            int x=dis_node[1];
            int y=dis_node[2];
            if(x==m-1 && y==n-1)return dis;
            for(int dir[]:dirs){
                int row=x+dir[0];
                int col=y+dir[1];
                int newdis=dis+1;
                if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==1)continue;
                if(newdis<dij[row][col]){
                    pq.add(new int[]{newdis,row,col});
                    dij[row][col]=newdis;
                }
            }
        }
        return -1;

    }
}
