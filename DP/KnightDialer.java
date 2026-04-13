import java.util.Arrays;

public class KnightDialer {
  // lc-935. Knight Dialer
  class Solution {
    int mod = (int) 1e9 + 7;

    int solve(int num, int n, int[][] dial, int[][] dp) {
      if (n == 1)
        return 1;
      if (dp[num][n] != -1)
        return dp[num][n];
      int ways = 0;
      for (int m : dial[num]) {
        ways = (ways + solve(m, n - 1, dial, dp)) % mod;

      }
      return dp[num][n] = ways;
    }

    int rec(int[][] dial, int n) {
      int[][] dp = new int[10][n + 1];
      for (var row : dp)
        Arrays.fill(row, -1);
      int ans = 0;
      for (int i = 0; i < 10; i++) {
        ans = (ans + solve(i, n, dial, dp)) % mod;

      }
      return ans;
    }

    int tabulation(int n, int[][] dial) {
      int dp[][] = new int[10][n + 1];
      for (int i = 0; i <= 9; i++)
        dp[i][1] = 1;
      for (int len = 2; len <= n; len++) {
        for (int num = 0; num <= 9; num++) {
          int[] ops = dial[num];
          int ways = 0;
          for (int x : ops) {
            ways = (ways + dp[x][len - 1]) % mod;
          }
          dp[num][len] = ways;
        }
      }
      int ans = 0;
      for (int i = 0; i <= 9; i++) {
        ans = (ans + dp[i][n]) % mod;
      }
      return ans;
    }

    public int knightDialer(int n) {
      int[][] dial = {
          { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 }
      };

      // return rec(dial,n);
      return tabulation(n, dial);
    }
  }
}
