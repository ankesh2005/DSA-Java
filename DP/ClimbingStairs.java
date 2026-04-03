import java.util.Arrays;

public class ClimbingStairs {
  // lc-70. Climbing Stairs
  class Solution {
    int solve(int n,int dp[]){
        if (n == 0) return 1;
        if (n < 0) return 0;
        if(dp[n]!=-1)return dp[n];
        int step1=solve(n-1,dp);
        int step2=solve(n-2,dp);
        return dp[n]=step1+step2;
    }
    int rec(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    int tabular(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int step1=dp[i-1];
            int step2=0;
            if(i-2>=0)step2=dp[i-2];
            dp[i]=step1+step2;
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        // return rec(n);
        return tabular(n);
    }
}
}
