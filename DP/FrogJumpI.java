import java.util.Arrays;

public class FrogJumpI {
    int solve(int n,int[] height,int[] dp){
        if(n==1)return 0;
        if(n<=0)return Integer.MAX_VALUE;
        if (dp[n] != -1) return dp[n];  
        int jump1=Math.abs(height[n-1]-height[n-2])+solve(n-1,height,dp);
        int jump2=Integer.MAX_VALUE;
        if(n>2) jump2=Math.abs(height[n-1]-height[n-3])+solve(n-2,height,dp);
        return dp[n] = Math.min(jump1, jump2);
    }
    int rec(int[] height){
        int n=height.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,height,dp);
    }
    int tabular(int[] height){
        int n=height.length;
        int dp[]=new int[n+1];
        dp[0]=Integer.MAX_VALUE;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int jump1=Math.abs(height[i-1]-height[i-2])+dp[i-1];
            int jump2=Integer.MAX_VALUE;
            if(i>2) jump2=Math.abs(height[i-1]-height[i-3])+solve(i-2,height,dp);
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[n];
    }
    int minCost(int[] height) {
        return rec(height);
    }
}
