import java.util.Arrays;

public class CoinsChange {
  // lc-322 Coins Change
    public int solve(int idx,int[] coins,int amount,int[][] dp){
        if(idx==0){
            if(amount%coins[idx]==0)return amount/coins[idx];
            else return (int)1e9;
        }
        if(dp[idx][amount]!=-1)return dp[idx][amount];
        int skip=solve(idx-1,coins,amount,dp);
        int take=(coins[idx]<=amount)?1+solve(idx,coins,amount-coins[idx],dp):Integer.MAX_VALUE;
        return dp[idx][amount]=Math.min(skip,take);
    }
    public int rec(int[] coins,int amount){
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        int ans= solve(coins.length-1,coins,amount,dp);
        return ans>=(int)1e9?-1:ans;
    }
    public int tabular(int[] coins,int amount){
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)dp[0][t]=t/coins[0];
            else dp[0][t]=amount+1;
        }
        for(int i=1;i<n;i++){
            for(int t=1;t<=amount;t++){
                int skip=dp[i-1][t];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=t)take=1+dp[i][t-coins[i]];
                dp[i][t]=Math.min(skip,take);
            }
        }
        return dp[n-1][amount]>=amount+1?-1:dp[n-1][amount];
    }
    public int coinChange(int[] coins, int amount) {
    //    return rec(coins,amount);
        return tabular(coins,amount);
    }
}
