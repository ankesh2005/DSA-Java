package SubsequenceDp;

import java.util.Arrays;

public class InterleavingString {
  // lc-97. Interleaving String
  class Solution {
    // used k->m+n
    boolean solve(int m, int n, int k, String s1, String s2, String s3, int[][] dp) {
      if (m == 0) {
        return s2.substring(0, n).equals(s3.substring(0, k));
      } else if (n == 0) {
        return s1.substring(0, m).equals(s3.substring(0, k));
      }
      if (dp[m][n] != -1)
        return dp[m][n] == 1;
      boolean first = false;
      boolean second = false;
      if (s1.charAt(m - 1) == s3.charAt(m + n - 1) && s2.charAt(n - 1) == s3.charAt(m + n - 1)) {
        first = solve(m - 1, n, k - 1, s1, s2, s3, dp);
        second = solve(m, n - 1, k - 1, s1, s2, s3, dp);
      } else if (s1.charAt(m - 1) == s3.charAt(m + n - 1)) {
        first = solve(m - 1, n, k - 1, s1, s2, s3, dp);
      } else if (s2.charAt(n - 1) == s3.charAt(m + n - 1)) {
        second = solve(m, n - 1, k - 1, s1, s2, s3, dp);
      }
      boolean res = first || second;
      dp[m][n] = res ? 1 : 0;
      return res;
    }

    boolean rec(String s1, String s2, String s3) {
      int m = s1.length();
      int n = s2.length();
      int k = s3.length();
      if (n + m < k || m + n > k)
        return false;
      int[][] dp = new int[m + 1][n + 1];
      for (int[] row : dp)
        Arrays.fill(row, -1);
      return solve(m, n, k, s1, s2, s3, dp);
    }

    boolean tabular(String s1, String s2, String s3) {
      int m = s1.length();
      int n = s2.length();
      int k = s3.length();
      if (n + m < k || m + n > k)
        return false;
      int[][] dp = new int[m + 1][n + 1];
      dp[0][0] = 1;
      for (int i = 1; i <= m; i++) {
        dp[i][0] = dp[i - 1][0] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1) ? 1 : 0;
      }
      for (int j = 1; j <= n; j++) {
        dp[0][j] = dp[0][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(j - 1) ? 1 : 0;
      }
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          boolean first = false;
          boolean second = false;
          if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
            first = dp[i - 1][j] == 1 ? true : false;
            second = dp[i][j - 1] == 1 ? true : false;
          } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
            first = dp[i - 1][j] == 1 ? true : false;
          } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
            second = dp[i][j - 1] == 1 ? true : false;
          }
          boolean res = first || second;
          dp[i][j] = res ? 1 : 0;
        }
      }
      return dp[m][n] == 1;

    }

    public boolean isInterleave(String s1, String s2, String s3) {
      // return rec(s1,s2,s3);
      return tabular(s1, s2, s3);
    }
  }
}
