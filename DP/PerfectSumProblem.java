public class PerfectSumProblem {
   public int solve(int idx,int target,int[][] dp,int[] nums){
      if(idx==0){
          if(target==0 && nums[idx]==0)return 2;
          if(target==0)return 1;
          if(target==nums[idx])return 1;
          return 0;
      }
       if(dp[idx][target]!=-1)return dp[idx][target];
       int skip=solve(idx-1,target,dp,nums);
       int take=0;
       if(nums[idx]<=target)take=solve(idx-1,target-nums[idx],dp,nums);
       dp[idx][target]=skip+take;
       return dp[idx][target];
       
   }
    public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        // int[][] dp=new int[n][target+1];
        // for(int[] row:dp)Arrays.fill(row,-1);
        // return solve(n-1,target,dp,nums);
        
        int[][] dp=new int[n][target+1];
       
        dp[0][0] = (nums[0] == 0) ? 2 : 1;
        if (nums[0] != 0 && nums[0] <= target)
    dp[0][nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int skip=dp[i-1][j];
                int take=0;
                if(nums[i]<=j)take=dp[i-1][j-nums[i]];
                dp[i][j]=skip+take;
            }
        }
        return dp[n-1][target];
       
    }
}
