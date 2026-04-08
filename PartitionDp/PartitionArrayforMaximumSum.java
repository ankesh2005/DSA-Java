package PartitionDp;
import java.util.Arrays;

public class PartitionArrayforMaximumSum {
  // lc-1043. Partition Array for Maximum Sum
  class Solution {
    int  solve(int i,int k,int [] arr,int[] dp){
        if(i==arr.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int sum=Integer.MIN_VALUE;
        int maxele=0;
        int max=0;
        for(int j=i;j<i+k && j<arr.length;j++){
            int len=j-i+1;
            maxele=Math.max(maxele,arr[j]);
            sum=maxele*len+solve(j+1,k,arr,dp);
            max=Math.max(max,sum);
        }
        return dp[i]=max;
    }
    public int rec(int[] arr,int k){
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,k,arr,dp);
    }
    public int tabular(int[] arr,int k){
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int maxele=0;
            int max=0;
            for(int j=i;j<i+k && j<n;j++){
                int len=j-i+1;
                maxele=Math.max(maxele,arr[j]);
                int sum=len*maxele+dp[j+1];
                max=Math.max(sum,max);
            }
            dp[i]=max;
        }
        return dp[0];
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // return rec(arr,k);
        return tabular(arr,k);
    }
}
}
