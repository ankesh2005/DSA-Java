import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
  // lc-123 Best Time to Buy and Sell Stock III
  class Solution {
    int solve(int idx, int[] prices, boolean buy, int cap, int[][][] dp) {
        if (cap == 0 || idx == prices.length)
            return 0;
        int b = buy ? 0 : 1;
        if (dp[idx][b][cap] != -1)
            return dp[idx][b][cap];
        int profit = 0;
        if (buy) {
            int buyOnSameDay = -1 * prices[idx] + solve(idx + 1, prices, false, cap, dp);
            int dontBuy = solve(idx + 1, prices, true, cap, dp);
            profit = Math.max(buyOnSameDay, dontBuy);
        } else {
            int sellOnSameDay = prices[idx] + solve(idx + 1, prices, true, cap - 1, dp);
            int dontSell = solve(idx + 1, prices, false, cap, dp);
            profit = Math.max(sellOnSameDay, dontSell);
        }
        return dp[idx][b][cap] = profit;

    }

    int rec(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, prices, true, 2, dp);
    }

    public int tabular(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // when cap is zero base case
        for (int idx = 0; idx <= n; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }
        // when idx is n base case
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }
        int buy=0,sell=1;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int j = 0; j <= 1; j++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (j == 0) {
                        int buyOnSameDay = -1 * prices[idx] + dp[idx + 1][sell][cap];
                        int dontBuy = dp[idx + 1][buy][cap];
                        profit = Math.max(buyOnSameDay, dontBuy);
                    }else{
                        int sellOnSameDay = prices[idx] + dp[idx + 1][buy] [cap-1];
                        int dontSell = dp[idx + 1][sell][cap];
                        profit = Math.max(sellOnSameDay, dontSell);
                    }
                    dp[idx][j][cap]=profit;
                }
            }
        }
        return dp[0][0][2];

    }

    public int maxProfit(int[] prices) {
        // return rec(prices);
        return tabular(prices);
    }
}
}
