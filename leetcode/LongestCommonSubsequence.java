public class LongestCommonSubsequence {
  class Solution {
    private static int helper(int m,int n,StringBuilder s1,StringBuilder s2,int[][]dp){
        if(m<0||n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m)==s2.charAt(n)) return dp[m][n]=1+helper(m-1,n-1,s1,s2,dp);
        return dp[m][n]= Math.max(helper(m-1,n,s1,s2,dp),helper(m,n-1,s1,s2,dp));
    }
    static int lcs(String s1, String s2) {
        // code here
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        dp[i][j]=-1;
        return helper(m-1,n-1,new StringBuilder(s1),new StringBuilder(s2),dp);
    }
}
}
