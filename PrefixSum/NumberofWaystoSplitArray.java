package PrefixSum;

public class NumberofWaystoSplitArray {
  // lc-2270. Number of Ways to Split Array
  public int waysToSplitArray(int[] nums) {
    int n = nums.length;
    long[] pre = new long[n];
    pre[0] = nums[0];
    for (int i = 1; i < n; i++) {
      pre[i] = pre[i - 1] + nums[i];
    }
    long total = pre[n - 1];
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      if (total - pre[i] <= pre[i])
        ans++;
    }
    return ans;
  }
}
