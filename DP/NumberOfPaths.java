import java.util.Arrays;

public class NumberOfPaths {
  public static int numberOfPAths(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    return paths(m, n, dp);
  }

  private static int paths(int m, int n, int[][] dp) {
    if (m == 0 || n == 0)
      return 0;
    if (m == 1 && n == 1)
      return 1;
    if (dp[m][n] != 0)
      return dp[m][n];
    return dp[m][n] = paths(m - 1, n, dp) + paths(m, n - 1, dp);
  }

  public static int numberOfPAths2(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  private static int numberOfPAths3(int m, int n) {
    if(m==1||n==1) return 1;
    int[][] dp = new int[2][n];
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }
    dp[1][0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        dp[1][j] = dp[1][j-1]+dp[0][j];
      }
      // filling first row from second row
      for (int j = 1; j < n; j++) {
        dp[0][j] = dp[1][j];
      }
  }
  return dp[1][n-1];
  }

  public static void main(String[] args) {
    // System.out.println(numberOfPAths(3, 3));
    // System.out.println(numberOfPAths2(3, 3));
    System.out.println(numberOfPAths3(3, 3));

  }
}
