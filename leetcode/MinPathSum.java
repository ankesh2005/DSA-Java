public class MinPathSum {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            if(i==0)dp[i][0]=grid[i][0];
            else dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=0;j<n;j++){
            if(j==0)dp[0][j]=grid[0][j];
            else dp[0][j]=grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

}
