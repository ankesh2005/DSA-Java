import java.util.Arrays;

public class BestTimetoBuyandSellStockIV {
  // lc-188. Best Time to Buy and Sell Stock IV
  class Solution {
    int solve(int idx,int[] prices,boolean buy,int cap,int[][][] dp){
        if(idx==prices.length || cap==0)return 0;
        int b=buy?0:1;
        if(dp[idx][b][cap]!=-1)return dp[idx][b][cap];
        int profit=0;
        if(buy){
            int buyOnSameDay=-1*prices[idx]+solve(idx+1,prices,false,cap,dp);
            int dontBuy=solve(idx+1,prices,true,cap,dp);
            profit=Math.max(dontBuy,buyOnSameDay);
        }else{
            int sellOnSameDay=prices[idx]+solve(idx+1,prices,true,cap-1,dp);
            int dontSell=solve(idx+1,prices,false,cap,dp);
            profit=Math.max(dontSell,sellOnSameDay);
        }
        return dp[idx][b][cap]=profit;
    }
    int rec(int[] prices,int k){
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        for(var grid:dp){
            for(var row:grid){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,prices,true,k,dp);
    }
    int tabular(int[] prices,int k){
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        //base case when idx is n
        for(int j=0;j<=1;j++){
            for(int cap=0;cap<=k;cap++){
                dp[n][j][cap]=0;
            }
        }
        //base case when cap is 0
        for(int idx=0;idx<=n;idx++){
            for(int j=0;j<=1;j++){
                dp[idx][j][0]=0;
            }
        }
        int buy=0,sell=1;
        for(int idx=n-1;idx>=0;idx--){
            for(int j=0;j<=1;j++){
                for(int cap=1;cap<=k;cap++){
                    int profit=0;
                    if(j==0){
                        int buyOnSameDay=-1*prices[idx]+dp[idx+1][sell][cap];
                        int dontBuy=dp[idx+1][buy][cap];
                        profit=Math.max(dontBuy,buyOnSameDay);
                    }else{
                        int sellOnSameDay=prices[idx]+dp[idx+1][buy][cap-1];
                        int dontSell=dp[idx+1][sell][cap];
                        profit=Math.max(sellOnSameDay,dontSell);
                    }
                    dp[idx][j][cap]=profit;
                }
            }
        }
        return dp[0][0][k];
    }
    public int maxProfit(int k, int[] prices) {
        // return rec(prices,k);
        return tabular(prices,k);
    }
}
}
