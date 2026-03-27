import java.util.Arrays;

public class PartitionEqualSubsetSum {
  // lc-416. Partition Equal Subset Sum
  public boolean solve(int[] nums, int idx, int target, int[][] dp) {
    if (target == 0)
      return true;
    if (idx == nums.length)
      return target == 0;
    if (target < 0)
      return false;
    if (dp[idx][target] != -1)
      return dp[idx][target] == 1;
    boolean take = solve(nums, idx + 1, target - nums[idx], dp);
    boolean skip = solve(nums, idx + 1, target, dp);
    dp[idx][target] = (take || skip) == true ? 1 : 0;
    return take || skip;
  }

  public boolean solve(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    boolean[][] dp = new boolean[n][sum / 2 + 1];
    for (int i = 0; i < n; i++)
      dp[i][0] = true;
    if (nums[0] <= sum / 2)
      dp[0][nums[0]] = true;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= sum / 2; j++) {
        boolean skip = dp[i - 1][j];
        boolean take = false;
        if (nums[i] <= j)
          take = dp[i - 1][j - nums[i]];
        dp[i][j] = skip || take;
      }
    }
    return dp[n - 1][sum / 2];
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    int[][] dp = new int[nums.length][sum / 2 + 1];
    for (int[] row : dp)
      Arrays.fill(row, -1);
    // return solve(nums,0,sum/2,dp);
    return solve(nums);
  }
}
