public class MinCostClimbingStairs {
   private int climb(int[] cost,int i,int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i]+Math.min(climb(cost,i+1,dp),climb(cost,i+2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        // int[] dp=new int[cost.length];
        // Arrays.fill(dp,-1);
        // return Math.min(climb(cost,0,dp),climb(cost,1,dp));
        if(cost.length<=2) return Math.min(cost[0],cost[1]);
        int[] dp=new int[3];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[2]=cost[i]+Math.min(dp[0],dp[1]);
            dp[0]=dp[1];
            dp[1]=dp[2];
        }
        return Math.min(dp[0],dp[1]);
    }
}
