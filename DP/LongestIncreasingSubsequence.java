public class LongestIncreasingSubsequence {
  class Solution {
    static int  helper(int i,int prev,int[] arr,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip=helper(i+1,prev,arr,dp);
        if(prev!=-1 && arr[i]<=arr[prev]) return dp[i][prev+1] =skip;
        int pick=1+helper(i+1,i,arr,dp);
        return dp[i][prev+1]=Math.max(pick,skip);
    }
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        // int[][] dp=new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(0,-1,arr,dp);
        
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=i;j>=0;j--){
                if(arr[i]>arr[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=1+max;
        }
        int ans=0;
        for(int val:dp){
            ans=Math.max(val,ans);
        }
        return ans;
    }
}
}
