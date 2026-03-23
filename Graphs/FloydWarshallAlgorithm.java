package Graphs;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
  // lc-1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
  class Solution {
    public int findTheCity(int n, int[][] edges, int thres) {
        int floyd[][]=new int[n][n];
        for(int[] row:floyd){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int[] edge:edges){ 
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            floyd[u][v]=w;
            floyd[v][u]=w;   
        }
        // Floyd warshal
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(k==i)continue;
                for(int j=0;j<n;j++){ 
                    if(j==k)continue;
                    if(i==j){floyd[i][j]=0; continue;}
                    if(floyd[i][k]!=Integer.MAX_VALUE && floyd[k][j]!=Integer.MAX_VALUE)
                    floyd[i][j]=Math.min(floyd[i][k]+floyd[k][j],floyd[i][j]);
                }
            }
        }
        int city=-1;
        int minCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(floyd[i][j]<=thres)count++;
            }
            if(count<=minCount){
                city=i;
                minCount=count;
            }
        }
        return city;
    }
}
}
