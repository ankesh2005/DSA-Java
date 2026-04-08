package PartitionDp;

import java.util.Arrays;

public class PalindromePartitioningII {
  // lc-132. Palindrome Partitioning II
  class Solution {
    boolean isPallindrome(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    int solve(int i,int n,String s,int[] dp){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPallindrome(s.substring(i,j+1))){
                int cut=1+solve(j+1,n,s,dp);
                min=Math.min(min,cut);
            }
        }
        return dp[i]=min;
    }
    int rec(String s){
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,s,dp)-1;
    }
    int tabular(String s){
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPallindrome(s.substring(i,j+1))){
                    int cut=1+dp[j+1];
                    min=Math.min(min,cut);
                }
        }
            dp[i]=min;
        }
        return dp[0]-1;
    }
    public int minCut(String s) {
        // return rec(s);
        return tabular(s);
    }
}
}
