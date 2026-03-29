package Dp;

import java.util.Arrays;

public class PartitionWithGivenDifference {
  int mod = 1000000007;

  public int solve(int[] nums, int target, int idx, int[][] dp) {
    if (idx == 0) {
      if (nums[idx] == 0 && target == 0)
        return 2;
      if (target == 0 || nums[idx] == target)
        return 1;
      return 0;
    }
    if (dp[idx][target] != -1)
      return dp[idx][target];
    int skip = solve(nums, target, idx - 1, dp);
    int take = 0;
    if (nums[idx] <= target)
      take = solve(nums, target - nums[idx], idx - 1, dp);
    dp[idx][target] = (take + skip) % mod;
    return dp[idx][target];
  }
                       
  public int rec(int[] arr, int diff) {
    int n = arr.length;
    int total = 0;
    for (var num : arr)
      total += num;
    if (total - diff < 0 || (total - diff) % 2 != 0)
      return 0;
    int target = (total - diff) / 2;
    int[][] dp = new int[n][target + 1];
    for (var row : dp)
      Arrays.fill(row, -1);
    return solve(arr, target, n - 1, dp);

  }

  public int tabular(int[] arr, int diff) {
    int n = arr.length;
    int total = 0;
    for (var num : arr)
      total += num;
    if (total - diff < 0 || (total - diff) % 2 != 0)
      return 0;
    int target = (total - diff) / 2;
    int dp[][] = new int[n][target + 1];
    if (arr[0] == 0) {
      dp[0][0] = 2; // take or skip 0, always 2 ways for sum=0
    } else {
      dp[0][0] = 1; // skip arr[0]
      if (arr[0] <= target)
        dp[0][arr[0]] = 1; // take arr[0]
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= target; j++) {
        int skip = dp[i - 1][j];
        int take = 0;
        if (arr[i] <= j)
          take = dp[i - 1][j - arr[i]];
        dp[i][j] = (take + skip) % mod;
      }
    }
    return dp[n - 1][target];
  }

  public int countPartitions(int[] arr, int diff) {
    // return rec(arr,diff);
    return tabular(arr, diff);
  }
}