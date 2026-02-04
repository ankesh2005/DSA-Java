public class EditDistance {
    private int solve(String s1, String s2, int[][] dp, int i, int j) {
        int m = s1.length();
        int n = s2.length();
        if (i == m) {
            return n - j;
        } else if (j == n) {
            return m - i;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, dp, i + 1, j + 1);
        }
        int insert = 1 + solve(s1, s2, dp, i, j + 1);
        int delete = 1 + solve(s1, s2, dp, i + 1, j);
        int replace = 1 + solve(s1, s2, dp, i + 1, j + 1);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    private int solve2(String s1, String s2, int[][] dp, int m, int n) {
        if (m==0||n==0) {
            return m+n;
        } 
        if (dp[m][n] != -1)
            return dp[m][n];

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return dp[m][n] = solve2(s1, s2, dp, m-1, n-1);
        }
        int insert = 1 + solve2(s1, s2, dp, m, n-1);
        int delete = 1 + solve2(s1, s2, dp, m-1, n);
        int replace = 1 + solve2(s1, s2, dp, m-1, n-1);
        return dp[m][n] = Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int x = 0; x <= m; x++) {
            for (int y = 0; y <= n; y++) {
                dp[x][y] = -1;
            }
        }
        // return solve(word1, word2, dp, 0, 0);
        // return solve2(word1, word2, dp, m, n);

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j]=i+j;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }
}
