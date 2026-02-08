public class TargetSum {
  // User function Template for Java

class Solution {
    private static int helper(int n,int[] arr,int target,int i,int sum,int[][] dp,int absSum){
        if (i == n) {
            return sum == target ? 1 : 0;
        }  
        if(dp[i][sum+absSum]!=0) return dp[i][sum+absSum];

        int minus=helper(n,arr,target,i+1,sum-arr[i],dp,absSum);
        int plus=helper(n,arr,target,i+1,sum+arr[i],dp,absSum);
        return dp[i][sum+absSum]=minus+plus;
    }
    static int findTargetSumWays(int N, int[] A, int target) {
        // code here
        int absSum=0;
        for(int x:A){
            absSum+=Math.abs(x);
        }
        int dp[][]=new int[N][2*absSum+1];
        return helper(N,A,target,0,0,dp,absSum);
    }
};
}
