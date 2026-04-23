package SubsequenceDp;

import java.util.Arrays;

public class LongestArithmeticSubsequence {
  // lc-1027. Longest Arithmetic Subsequence
  class Solution {
    int solve(int[] nums,int prev1,int prev2,int idx,int[][][] dp){
        if(idx==nums.length)return 0;
        if(dp[idx][prev1+1][prev2+1]!=-1)return dp[idx][prev1+1][prev2+1];
        int len=0;
        int take=0;
        if(prev1==-1 && prev2==-1 ){
            take=1+solve(nums,idx,prev2,idx+1,dp);
        }
        else if(prev2==-1 ){
            take=1+solve(nums,prev1,idx,idx+1,dp);
        }else if(prev1!=-1 && prev2!=-1 && nums[prev2]-nums[prev1]==nums[idx]-nums[prev2] ){
            take=1+solve(nums,prev2,idx,idx+1,dp);
        }
        int skip=0;
        skip=solve(nums,prev1,prev2,idx+1,dp);
        return dp[idx][prev1+1][prev2+1]=Math.max(skip,take);
    }
    int memo(int[] nums){
        int n=nums.length;
        int[][][] dp=new int[n][n+1][n+1];
        for(int box[][]:dp){
            for(int [] row:box){
            Arrays.fill(row,-1);
            }
        }
        return solve(nums,-1,-1,0,dp);
    }
    public int longestArithSeqLength(int[] nums) {
        // return memo(nums); memory limit exced
        int n=nums.length;
        int[][] dp = new int[n][1001];
        int ans = 2;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500; // shift range [-500,500] → [0,1000]
                int len = dp[j][diff] == 0 ? 2 : dp[j][diff] + 1;
                dp[i][diff] = Math.max(dp[i][diff], len);
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans;
    }
}
}
