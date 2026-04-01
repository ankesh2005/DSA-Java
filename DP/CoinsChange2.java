import java.util.Arrays;

public class CoinsChange2 {
  // lc-518. Coins Change II
  class Solution {
    public int solve(int idx,int[] coins,int amount,int[][]dp){
        if(idx==0){
            if(amount%coins[idx]==0)return 1;
            else return 0;
        }
        if(dp[idx][amount]!=-1)return dp[idx][amount];
        int skip=solve(idx-1,coins,amount,dp);
        int take=0;
        if(coins[idx]<=amount)take=solve(idx,coins,amount-coins[idx],dp);
        return dp[idx][amount]=skip+take;
    }
    public int rec(int amount,int[] coins){
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(n-1,coins,amount,dp);
    }
    public int tabular(int amount,int[] coins){
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int t=0;t<=amount;t++){
            dp[0][t]=t%coins[0]==0?1:0;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int skip=dp[i-1][t];
                int take=0;
                if(coins[i]<=t)take=dp[i][t-coins[i]];
                dp[i][t]=skip+take;
            }
        }
        return dp[n-1][amount];
    }
    public int change(int amount, int[] coins) {
        // return rec(amount,coins);
        return tabular(amount,coins);
    }
}
}
