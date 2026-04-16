import java.util.Arrays;

public class LargestSumofAverages {
  // lc-813. Largest Sum of Averages
  class Solution {
    public double solve(int[] nums, int k, int idx, double[][] dp) {
        int n = nums.length;
        if (k == 0) {
            if (idx == n)
                return 0.0;
            double sum = 0;
            for (int i = idx; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum / (nums.length - idx);
        }
        if (dp[idx][k] != -1)
            return dp[idx][k];
        double avg = 0.0;
        double sum = 0.0;
        for (int j = idx; j < n; j++) {
            sum += nums[j];
            //partition
            double brk = 0;
            if (k > 0)
                brk = solve(nums, k - 1, j + 1, dp);
            double avgt = sum / (j - idx + 1);
            avg = Math.max(avg, avgt + brk);
        }
        return dp[idx][k] = avg;
    }

    public double memo(int[] nums, int k) {
        double[][] dp = new double[nums.length + 1][k];
        for (double[] row : dp)
            Arrays.fill(row, -1);
        return solve(nums, k - 1, 0, dp);//since need to break into k groups we have to break only k-1 times
    }

    public double tabulation(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n + 1][k + 1];
        double sum = 0.0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            dp[i][0] = sum / (n - i);
        }
        dp[n][0] = 0.0;
        for (int i = n - 1; i >= 0; i--) {
            for (int cut = 1; cut < k; cut++) {
                double avg = 0.0;
                sum = 0.0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    //partition
                    double brk = 0;
                    if (cut > 0)
                        brk = dp[j + 1][cut - 1];
                    double avgt = sum / (j - i + 1);
                    avg = Math.max(avg, avgt + brk);
                }
                dp[i][cut] = avg;
            }
        }
        return dp[0][k - 1];
    }

    public double largestSumOfAverages(int[] nums, int k) {
        // return memo(nums, k);
        return tabulation(nums, k);
    }
}
}
