import java.util.Arrays;

public class PathsinMatrixWhoseSumIsDivisiblebyK {
  // lc-2345. Paths in Matrix Whose Sum Is Divisible by K
  class Solution {
    int mod = (int) 1e9 + 7;

    int solve(int[][] grid, int i, int j, int rem, int k, int[][][] dp) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length)
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if ((rem + grid[i][j]) % k == 0)
                return 1;
            else
                return 0;
        }
        if (dp[i][j][rem] != -1)
            return dp[i][j][rem];

        //down
        int down = solve(grid, i + 1, j, (rem + grid[i][j]) % k, k, dp);
        //right
        int right = solve(grid, i, j + 1, (rem + grid[i][j]) % k, k, dp);

        return dp[i][j][rem] = (right + down) % mod;

    }

    int memo(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        for (var box : dp) {
            for (var row : box) {
                Arrays.fill(row, -1);
            }
        }
        return solve(grid, 0, 0, 0, k, dp);
    }

    public int tabulation(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        //base case - out of boundary dp[i][j][k]=0
        for (int rem = 0; rem < k; rem++) {
            dp[m - 1][n - 1][rem] = (rem + grid[m - 1][n - 1]) % k == 0 ? 1 : 0;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int rem = 0; rem < k; rem++) {
                    if(i==m-1 && j==n-1)continue;
                    //down
                    int down = dp[ i + 1][ j][ (rem + grid[i][j]) % k];
                    //right
                    int right = dp[i][j + 1][(rem + grid[i][j]) % k];

                    dp[i][j][rem] = (right + down) % mod;
                }
            }
        }
        return dp[0][0][0];
    }

    public int numberOfPaths(int[][] grid, int k) {
        // return memo(grid,k);
        return tabulation(grid, k);
    }
}

}
