import java.util.Arrays;

public class BestTimetoBuyandSellStockwithCooldown {
  // lc-309. Best Time to Buy and Sell Stock with Cooldown
  class Solution {
    int solve(int idx,int[] prices,boolean buy,int[][] dp){
        if(idx>=prices.length)return 0;
        int b=buy?0:1;
        if(dp[idx][b]!=-1)return dp[idx][b];
        int profit=0;
        if(buy){
            int buyOnSameDay=-1*prices[idx]+solve(idx+1,prices,false,dp);
            int dontBuy=solve(idx+1,prices,true,dp);
            profit=Math.max(buyOnSameDay,dontBuy);
        }else{
            int sellOnSameDay=prices[idx]+solve(idx+2,prices,true,dp);
            int dontSell=solve(idx+1,prices,false,dp);
            profit=Math.max(sellOnSameDay,dontSell);
        }
        return dp[idx][b]=profit;
    }
    int rec(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(0,prices,true,dp);
    }

    int tabular(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        // base case when idxis n and greater than n
        for(int idx=n;idx<=n+1;idx++){
            for(int j=0;j<=1;j++){
                dp[idx][j]=0;
            }
        }
        int buy=0,sell=1;
        for(int idx=n-1;idx>=0;idx--){
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==0){
                    int buyOnSameDay=-1*prices[idx]+dp[idx+1][sell];
                    int dontBuy=dp[idx+1][buy];
                    profit=Math.max(buyOnSameDay,dontBuy);
                }else{
                    int sellOnSameDay=prices[idx]+dp[idx+2][buy];
                    int dontSell=dp[idx+1][sell];
                    profit=Math.max(sellOnSameDay,dontSell);
                }
                dp[idx][j]=profit;
            }
        }
        return dp[0][0];

    }
    public int maxProfit(int[] prices) {
        // return rec(prices);
        return tabular(prices);
    }
}
}
