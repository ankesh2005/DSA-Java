import java.util.Arrays;

public class OutofBoundaryPaths {
  // lc-576. Out of Boundary Paths
  class Solution {
    int mod = (int) 1e9 + 7;

    int solve(int m, int n, int k, int sr, int sc, int[][][] dp) {
      if (sr < 0 || sc < 0 || sr == m || sc == n)
        return 1;

      if (k <= 0)
        return 0;
      if (dp[sr][sc][k] != -1)
        return dp[sr][sc][k];
      int ways = 0;
      int[][] shots = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
      for (int[] shot : shots) {
        ways = (ways + solve(m, n, k - 1, sr + shot[0], sc + shot[1], dp)) % mod;
      }
      return dp[sr][sc][k] = ways % mod;
    }

    int memo(int m, int n, int k, int sr, int sc) {
      int[][][] dp = new int[m + 1][n + 1][k + 1];
      for (var box : dp) {
        for (var row : box) {
          Arrays.fill(row, -1);
        }
      }
      return solve(m, n, k, sr, sc, dp);
    }

    int tabulation(int m, int n, int k, int sr, int sc) {
      int[][][] dp = new int[m][n][k + 1];
      for (int x = 1; x <= k; x++) {
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            int ways = 0;
            int[][] shots = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            for (int[] shot : shots) {
              if (i + shot[0] < 0 || i + shot[0] >= m || j + shot[1] < 0 || j + shot[1] >= n) {
                ways += 1;
              } else {
                ways = (ways + dp[i + shot[0]][j + shot[1]][x - 1]) % mod;
              }
            }
            dp[i][j][x] = ways;
          }
        }
      }
      return dp[sr][sc][k];

    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
      return memo(m, n, maxMove, startRow, startColumn);
      // return tabulation(m, n, maxMove, startRow, startColumn);
    }
  }

}
