import java.util.Arrays;

public class DeleteOperationforTwoStrings {
  // lc-583. Delete Operation for Two Strings
  class Solution {
    public int solve(int m,int n,String s1,String s2,int[][] dp){
        if(m==0 || n==0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))return dp[m][n]=1+solve(m-1,n-1,s1,s2,dp);
        else{
            return dp[m][n]=Math.max(solve(m-1,n,s1,s2,dp),solve(m,n-1,s1,s2,dp));
        }
    }
    public int rec(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(var row:dp)Arrays.fill(row,-1);
        return m+n-2*solve(m,n,s1,s2,dp);
    }
    public int tabular(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return m+n-2*dp[m][n];
    }
    public int minDistance(String word1, String word2) {
        // return tabular(word1,word2);
        return rec(word1,word2);
    }
}
}
