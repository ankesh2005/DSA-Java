import java.util.Arrays;

public class PerfectSquares {
  class Solution {
    private boolean isPerfect(int n){
        int sqrt=(int) Math.sqrt(n);
        return sqrt*sqrt==n;
    }
    private int helper(int n,int[] dp){
        if(isPerfect(n)) return 1;
        if(dp[n]!=-1) return dp[n];
        int min=n;
        for(int i=1;i*i<=n;i++){
            int w=helper(i*i,dp)+helper(n-i*i,dp);
            min=Math.min(min,w);
        }
        return dp[n]=min;
    }
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        //Arrays.fill(dp, -1);
        // return helper(n,dp);
        for(int i=1;i<=n;i++){
            if(isPerfect(i)) dp[i]=1;
            else{
                int min=i;
                for(int j=1;j*j<i;j++){
                    int count=dp[j*j]+dp[i-j*j];
                    min=Math.min(min,count);
                }
                dp[i]=min;
            }
        }
        return dp[n];
    }
}
}
