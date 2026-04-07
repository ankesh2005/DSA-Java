package PartitionDp;
import java.util.Arrays;

public class MatrixChainMultiplication {
  class Solution {
    static int solve(int[] arr,int i,int j,int[][] dp){
        if(i==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ops=arr[i-1]*arr[k]*arr[j]+solve(arr,i,k,dp)+solve(arr,k+1,j,dp);
            min=Math.min(ops,min);
        }
        return dp[i][j]=min;
    }
    static int rec(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(arr,1,n-1,dp);
    }
    static int tabular(int arr[]){
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int ops=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(min,ops);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }
    static int matrixMultiplication(int arr[]) {
        // return rec(arr);
        return tabular(arr);
        
    }
}
}
