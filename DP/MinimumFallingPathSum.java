public class MinimumFallingPathSum {
  // lc-931. Minimum Falling Path Sum
  class Solution {
    public int minFallingPathSum(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[] prev = new int[cols];
      for (int i = 0; i < cols; i++) {
        prev[i] = matrix[0][i];
      }
      for (int row = 1; row < rows; row++) {
        int[] curr = new int[cols];
        for (int col = 0; col < cols; col++) {
          if (col == 0) {
            curr[col] = matrix[row][col] + Math.min(prev[col], prev[col + 1]);
          } else if (col == cols - 1) {
            curr[col] = matrix[row][col] + Math.min(prev[col], prev[col - 1]);
          } else {
            curr[col] = matrix[row][col] + Math.min(prev[col], Math.min(prev[col + 1], prev[col - 1]));
          }
        }
        prev = curr;
      }
      int ans = Integer.MAX_VALUE;
      for (int col = 0; col < cols; col++) {
        ans = Math.min(ans, prev[col]);
      }
      return ans;

    }
  }
}
