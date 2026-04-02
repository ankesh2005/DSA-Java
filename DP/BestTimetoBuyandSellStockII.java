import java.util.Arrays;

public class BestTimetoBuyandSellStockII {
  // lc-122. est Time to Buy and Sell Stock II
  class Solution {
    int solve(int idx,int[] prices,boolean buy,int[][] dp){
        if(idx==prices.length+1)return 0;
        int b=buy?0:1;
        if(dp[idx][b]!=-1)return dp[idx][b]; 
        int profit=0;
        if(buy){
            int buyOnSameDay=-1*prices[idx-1]+solve(idx+1,prices,false,dp);
            int dontBuy=0+solve(idx+1,prices,true,dp);
            profit=Math.max(profit,Math.max(buyOnSameDay,dontBuy));
        }else{
            int sellOnSameDay=prices[idx-1]+solve(idx+1,prices,true,dp);
            int dontSell=solve(idx+1,prices,false,dp);
            profit=Math.max(profit,Math.max(sellOnSameDay,dontSell));
        }
        return dp[idx][b]=profit;
    }
    public int rec(int[] prices){
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(var row:dp)Arrays.fill(row,-1);
        dp[0][0]=dp[0][1]=0;
        return solve(1,prices,true,dp);
    }
    int tabular(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            int profit=0;
            for(int j=0;j<=1;j++){
                if(j==0){
                    int buyOnSameDay=-1*prices[i]+dp[i+1][1];
                    int dontBuy=dp[i+1][0];
                    profit=Math.max(dontBuy,buyOnSameDay);
                    dp[i][0]=profit;
                }else{
                    int sellOnSameDay=prices[i]+dp[i+1][0];
                    int dontSell=dp[i+1][1];
                    profit=Math.max(sellOnSameDay,dontSell);
                    dp[i][1]=profit;
                }
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
