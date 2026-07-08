
public class CherryPickup {
// lc-741. Cherry Pickup
class Solution {
    int pick(int r1, int c1, int r2, int[][] grid,int[][][] dp) {
        int c2=r1+c1-r2;
        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1
                || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2]!=-1)return dp[r1][c1][r2];
        int cherry = 0;
        if (r1 == r2 && c1 == c2) {
            cherry += grid[r1][c1];
        } else {
            cherry += grid[r1][c1] + grid[r2][c2];
        }
        int f1 = pick(r1 + 1, c1, r2 + 1, grid,dp);//d d
        int f2 = pick(r1 + 1, c1, r2, grid,dp);//d r
        int f3 = pick(r1, c1 + 1, r2 + 1, grid,dp);//r d
        int f4 = pick(r1, c1 + 1, r2, grid,dp);//r r
        int best = Math.max(Math.max(f1, f2), Math.max(f3, f4));
        if (best == Integer.MIN_VALUE) {
            return dp[r1][c1][r2] =Integer.MIN_VALUE;
        }

        return dp[r1][c1][r2]=cherry+best;
    }

    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][][] dp = new int[n][n][n];

for (int[][] arr : dp)
    for (int[] row : arr)
        Arrays.fill(row, -1);
        return Math.max(0, pick(0, 0, 0, grid,dp));
    }
}
  
}