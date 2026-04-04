public class CountSquareSubmatriceswithAllOnes {
  // lc-1277. Count Square Submatrices with All Ones
  public int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int dp[][] = new int[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
          count += dp[i][j];
        } else {
          if (matrix[i][j] == 0) {
            continue;
          } else {
            int left = dp[i][j - 1];
            int dig = dp[i - 1][j - 1];
            int up = dp[i - 1][j];
            dp[i][j] = Math.min(left, Math.min(dig, up)) + 1;
            count += dp[i][j];
          }

        }
      }
    }
    return count;
  }
}
