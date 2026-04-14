public class CombinationSumIV {
  // lc-377. Combination Sum IV
  class Solution {
    int solve(int target, int[] nums, int[] dp) {
        if (target == 0)
            return 1;
        if (dp[target] != -1)
            return dp[target];
        int ways = 0;
        for (int num : nums) {
            if (num <= target)
                ways += solve(target - num, nums, dp);
        }
        return dp[target] = ways;
    }

    int memo(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(target, nums, dp);
    }

    int tabulation(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int ways = 0;
            for (int num : nums) {
                if (num <= i)
                    ways += dp[i - num];
            }
            dp[i]=ways;
        }
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        // return memo(nums, target);
        return tabulation(nums,target);
    }
}
  
}