import java.util.Arrays;

public class LongestPalindromicSubsequence {
  // lc-516. Longest Palindromic Subsequence
  class Solution {
    public int solve(String s,int m,int n,int[][] dp){
        if(m>n)return 0;
        if(m==n)return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s.charAt(m)==s.charAt(n))return dp[m][n]=2+solve(s,m+1,n-1,dp);
        else{
            return dp[m][n]=Math.max(solve(s,m+1,n,dp),solve(s,m,n-1,dp));
        }
    }
    public int rec(String s){
        int n=s.length();
        int[][] dp=new int[n][n];
        for(var row:dp)Arrays.fill(row,-1);
        return solve(s,0,n-1,dp);//ya lcs(s,rev(s))
    }
    public int tabular(String s){
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)dp[i][i]=1;
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len==2){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
        
    }
    public int longestPalindromeSubseq(String s) {
        // return rec(s);
        return tabular(s);
       
    }
}
}
