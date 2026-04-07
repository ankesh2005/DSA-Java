package PartitionDp;
import java.util.Arrays;

public class DifferentWaystoEvaluateaBooleanExpression {

  class Solution {
    static int solve(String s, int i, int j, int isTrue, int[][][] dp) {
      if (i > j)
        return 0;
      if (i == j) {
        if (s.charAt(i) == 'T') {
          return isTrue == 1 ? 1 : 0;
        } else {
          return isTrue == 0 ? 1 : 0;
        }
      }
      if (dp[i][j][isTrue] != -1)
        return dp[i][j][isTrue];
      int ways = 0;
      for (int k = i + 1; k <= j - 1; k += 2) {
        int lt = solve(s, i, k - 1, 1, dp);// left true
        int lf = solve(s, i, k - 1, 0, dp);// left false
        int rt = solve(s, k + 1, j, 1, dp);// right true
        int rf = solve(s, k + 1, j, 0, dp);
        if (s.charAt(k) == '&') {
          if (isTrue == 1) {
            ways += lt * rt;
          } else {
            ways += lt * rf + lf * rf + lf * rt;
          }
        } else if (s.charAt(k) == '|') {
          if (isTrue == 1) {
            ways += lt * rf + lt * rt + lf * rt;
          } else {
            ways += lf * rf;
          }
        } else {
          if (isTrue == 1) {
            ways += lt * rf + lf * rt;
          } else {
            ways += lf * rf + rt * lt;
          }
        }
      }
      return dp[i][j][isTrue] = ways;
    }

    static int rec(String s) {
      int n = s.length();
      int dp[][][] = new int[n][n][2];
      for (var grid : dp) {
        for (var row : grid) {
          Arrays.fill(row, -1);
        }
      }
      // 1-true 0-false
      return solve(s, 0, n - 1, 1, dp);
    }

    static int tabular(String s) {
      int n = s.length();
      int dp[][][] = new int[n + 1][n + 1][2];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = 0; j <= n - 1; j++) {
          for (int isTrue = 0; isTrue <= 1; isTrue++) {
            if (i == j) {
              if (s.charAt(i) == 'T') {
                dp[i][j][1] = 1;
                dp[i][j][0] = 0;
              } else {
                dp[i][j][1] = 0;
                dp[i][j][0] = 1;
              }
              continue;
            }

            int ways = 0;
            for (int k = i + 1; k <= j - 1; k += 2) {
              int lt = dp[i][k - 1][1];// left true
              int lf = dp[i][k - 1][0];// left false
              int rt = dp[k + 1][j][1];// right true
              int rf = dp[k + 1][j][0];
              if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                  ways += lt * rt;
                } else {
                  ways += lt * rf + lf * rf + lf * rt;
                }
              } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                  ways += lt * rf + lt * rt + lf * rt;
                } else {
                  ways += lf * rf;
                }
              } else {
                if (isTrue == 1) {
                  ways += lt * rf + lf * rt;
                } else {
                  ways += lf * rf + rt * lt;
                }
              }
            }
            dp[i][j][isTrue] = ways;
          }

        }
      }
      return dp[0][n - 1][1];
    }

    static int countWays(String s) {
      // return rec(s);
      return tabular(s);

    }
  }

}
