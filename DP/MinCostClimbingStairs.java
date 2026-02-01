import java.util.Arrays;

public class MinCostClimbingStairs {
  static int[] dp;
  static int minCostClimbingStairs(int[] cost) {
    // recursion
      // return Math.min(climb(0,cost),climb(1,cost));

      // dp
      dp=new int[cost.length];
      Arrays.fill(dp,-1);
      return Math.min(climb(0, cost),climb(1, cost));
    }
  static int climb(int i,int[] cost){
    // recursion
    //  if(i>=cost.length) return 0;
    //  return cost[i]+Math.min(climb(i+1, cost),climb(i+2, cost));

    // dp
    if(i>=cost.length) return 0;
    if(dp[i]!=-1) return dp[i];
    dp[i]=cost[i]+Math.min(climb(i+1, cost),climb(i+2, cost));
    return dp[i];
  }
  public static void main(String[] args) {
    System.out.println(minCostClimbingStairs(new int[]{1,2,10,1,1,5}));
  }
}
