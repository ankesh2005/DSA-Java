package PartitionDp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {
  // lc-1547. Minimum Cost To A Stick
  class Solution {
    int solve(List<Integer>cuts,int i,int j,int[][] dp){
        if(i+1==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=cuts.get(j)-cuts.get(i)+solve(cuts,i,k,dp)+solve(cuts,k,j,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
    int rec(List<Integer>cuts,int n){
        int m=cuts.size();
        int[][] dp=new int[m][m];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(cuts,0,m-1,dp);
        
    }
    int tabular(List<Integer> cuts){
        int m=cuts.size();
        int dp[][]=new int[m][m];
        for(int i=0;i<m-1;i++){
            dp[i][i+1]=0;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=i+2;j<m;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int cost=cuts.get(j)-cuts.get(i)+dp[i][k]+dp[k][j];
                    min=Math.min(cost,min);
                }
                dp[i][j]=min;
            }
        }
        return dp[0][m-1];
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> list=new ArrayList<>();
        for(int cut:cuts){
            list.add(cut);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);
        // return rec(list,n);
        return tabular(list);
    }
}
}
