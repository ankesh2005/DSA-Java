import java.util.Arrays;

public class LongestCommonSubSequence {
    // lc-1143. Longest Common Subsequence 
    class Solution {
    public int solve(String str1,String str2,int m,int n,int[][] dp){
        if(m==0||n==0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        if(str1.charAt(m-1)==str2.charAt(n-1))return dp[m][n]=1+solve(str1,str2,m-1,n-1,dp);
        else{
            return dp[m][n]=Math.max(solve(str1,str2,m-1,n,dp),solve(str1,str2,m,n-1,dp));
        }
    }
    public int rec(String str1,String str2){
        int m=str1.length(),n=str2.length();
        int dp[][]=new int[m+1][n+1];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(str1,str2,m,n,dp);
    }
    public int tabular(String str1,String str2){
        int m=str1.length(),n=str2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // return rec(text1,text2);
        return tabular(text1,text2);
    }
}
  class Solution {
    
    public static int minSuperSeq(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return m-dp[m][n]+n;
    }
}
}
