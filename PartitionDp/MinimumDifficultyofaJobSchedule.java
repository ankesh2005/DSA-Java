package PartitionDp;

public class MinimumDifficultyofaJobSchedule {
  // lc-1335. Minimum Difficulty of a Job Schedule
  class Solution {
    int solve(int i,int d,int[] arr,int[][] dp){
        if(d==0 && i==arr.length )return 0;
        if(d==0 || i==arr.length)return (int)1e8;
        if(dp[i][d]!=-1)return dp[i][d];
        int maxele=arr[i];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<arr.length;k++){
            maxele=Math.max(maxele,arr[k]);
            int diff=maxele+solve(k+1,d-1,arr,dp);
            min=Math.min(diff,min);
        }
        return dp[i][d]=min;
    }
    int rec(int[] arr,int d){
        int n=arr.length;
        if(d>n)return -1;
        int[][] dp=new int[n][d+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(0,d,arr,dp);
    }
    int tabular(int[] arr,int d){
        int n=arr.length;
        int[][] dp=new int[n+1][d+1];
        if(d>n)return -1;
        // base case
        for(int j=0;j<=d;j++){
            dp[n][j]=(int)1e8;
        }
        for(int j=0;j<=n;j++){
            dp[j][0]=(int)1e8;
        }
        dp[n][0]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=d;j++){
                int min=(int)1e8;
                int maxele=0;
                for(int k=i;k<n;k++){
                    maxele=Math.max(maxele,arr[k]);
                    int diff=maxele+dp[k+1][j-1];
                    min=Math.min(min,diff);
                }
                dp[i][j]=min;
            }
        }
        return dp[0][d];
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        // return rec(jobDifficulty,d);
        return tabular(jobDifficulty,d);
    }
}
  
}