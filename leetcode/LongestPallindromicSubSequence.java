public class LongestPallindromicSubSequence {
  class Solution {
    private int helper(int i,int j,StringBuilder s,int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]= 2+helper(i+1,j-1,s,dp);
        return dp[i][j]= Math.max(helper(i+1,j,s,dp),helper(i,j-1,s,dp));
    }
    public int longestPalinSubseq(String s) {
        // code here
        
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,n-1,new StringBuilder(s),dp);
    }
}
}
