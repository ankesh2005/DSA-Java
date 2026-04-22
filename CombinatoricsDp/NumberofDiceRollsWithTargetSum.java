package CombinatoricsDp;

import java.util.Arrays;

public class NumberofDiceRollsWithTargetSum {
    // lc-1155. Number of Dice Rolls With Target Sum
  class Solution {
    int mod=(int)1e9+7;
    public int solve(int n,int k,int target,int[][] dp){
        if(n==0){
            if(target==0)return 1;
            return 0;
        }
        if(target<0)return 0;
        if(dp[n][target]!=-1)return dp[n][target];
        int ways=0;
        for(int i=1;i<=k;i++){
            int count=solve(n-1,k,target-i,dp)%mod;
            ways=(ways+count)%mod;
        }
        return dp[n][target]=ways;
    }
    public int memo(int n,int k,int target){
        int dp[][]=new int[n+1][target+1];
        for(var row:dp){
            Arrays.fill(row,-1);
        }
        return solve(n,k,target,dp);
    }
    public int numRollsToTarget(int n, int k, int target) {
        return memo(n,k,target);
    }
}
}
