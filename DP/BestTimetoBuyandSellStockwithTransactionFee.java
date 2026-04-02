import java.util.Arrays;

public class BestTimetoBuyandSellStockwithTransactionFee {
  // lc-714. Best Time to Buy and Sell Stock with Transaction Fee
  class Solution {
    int solve(int idx,int[] prices,int fee,boolean buy,int[][] dp){
        if(idx==prices.length)return 0;
        int b=buy?0:1;
        if(dp[idx][b]!=-1)return dp[idx][b];
        int profit=0;
        if(buy){
            int buyOnSameDay=-1*prices[idx]+solve(idx+1,prices,fee,false,dp);
            int dontBuy=solve(idx+1,prices,fee,true,dp);
            profit=Math.max(buyOnSameDay,dontBuy);
        }else{
            int sellOnSameDay=prices[idx]-fee+solve(idx+1,prices,fee,true,dp);
            int dontSell=solve(idx+1,prices,fee,false,dp);
            profit=Math.max(sellOnSameDay,dontSell);
        }
        return dp[idx][b]=profit;
    }
    int rec(int[] prices,int fee){
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(0,prices,fee,true,dp);
    }
    int tabular(int prices[],int fee){
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        // base case when idx is n
        dp[n][0]=dp[n][1]=0;
        int buy=0,sell=1;
        for(int idx=n-1;idx>=0;idx--){
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==0){
                    int buyOnSameDay=-1*prices[idx]+dp[idx+1][sell];
                    int dontBuy=dp[idx+1][buy];
                    profit=Math.max(buyOnSameDay,dontBuy);
                }else{
                    int sellOnSameDay=prices[idx]-fee+dp[idx+1][buy];
                    int dontSell=dp[idx+1][sell];
                    profit=Math.max(sellOnSameDay,dontSell);
                }
                dp[idx][j]=profit;
            }
        }
        return dp[0][0];
    }
    public int maxProfit(int[] prices, int fee) {
        // return rec(prices,fee);
        return tabular(prices,fee);
    }
}
}
