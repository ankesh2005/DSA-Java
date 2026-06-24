package SubsequenceDp;
import java.util.Arrays;

public class MinimumInsertionStepstoMakeaStringPalindrome {
  // lc-1312. Minimum Insertion Steps to Make a String Palindrome
  class Solution {
    public int solve(int m,int n,String s,int[][] dp){
        if(m>n)return 0;
        if(m==n)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        if(s.charAt(m)==s.charAt(n))return dp[m][n]=2+solve(m+1,n-1,s,dp);
        else{
           return dp[m][n]=Math.max(solve(m+1,n,s,dp),solve(m,n-1,s,dp));
        }
    }
    public int rec(String s){
        int n=s.length();
        int dp[][] =new int[n][n];
        for(var row:dp)Arrays.fill(row,-1);
        return n-solve(0,n-1,s,dp);
    }
    public int tabular(String s){
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int len=1;len<=n;len++){
            int i=0,j=len;
            while(j<n){
                if(s.charAt(i)==s.charAt(j)){
                    if(len+1==2){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=2+dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
                i++;j++;
            }
        }
        return n-dp[0][n-1];
    }
    public int minInsertions(String s) {
        // return tabular(s);
        return rec(s);
    }
}
}
