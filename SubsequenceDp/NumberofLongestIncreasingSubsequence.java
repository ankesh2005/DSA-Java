package SubsequenceDp;
import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
  // lc-673. Number of Longest Increasing Subsequence
  class Solution {
    int maxlen=0;
    int[] lis(int idx,int prev,int[] nums,int[][][] dp){
        if(idx==nums.length)return  new int[]{0,1};
        if(dp[idx][prev+1][0]!=-1)return new int[]{dp[idx][prev+1][0],dp[idx][prev+1][1]};
        int[] skip=lis(idx+1,prev,nums,dp);
        int take[]=new int[]{0,0};
        if(prev==-1 || nums[prev]<nums[idx]){
            int next[]=lis(idx+1,idx,nums,dp);
            take[0]=1+next[0];
            take[1]=next[1];
        }
        int best=Math.max(skip[0],take[0]);
        int ways=0;
        if(skip[0]==best)ways+=skip[1];
        if(take[0]==best)ways+=take[1];
        
        dp[idx][prev+1][0]=best;
        dp[idx][prev+1][1]=ways;
        return new int[]{best,ways};

    }
    public int rec(int[] nums){
        int n=nums.length;
        int dp[][][]=new int[n][n+1][2];
        for(int[][] grid:dp){
            for(int[] row:grid){
                Arrays.fill(row,-1);
            }
        }
        int[] result = lis(0, -1, nums, dp);
        maxlen = result[0];

        return result[1];
    }
    int tabular(int[] nums){
        int n=nums.length;
        int dp[]=new int[n];
        int[] count=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i] && (1+dp[prev]>dp[i])){
                    dp[i]=1+dp[prev];
                    count[i]=count[prev];
                }
                else if(nums[prev]<nums[i] && 1+dp[prev]==dp[i]){
                    count[i]+=count[prev];
                }
            }
            max=Math.max(max,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(max==dp[i]){
                ans+=count[i];
            }
        }
        return ans;
    }
    public int findNumberOfLIS(int[] nums) {
        // return rec(nums);
        return tabular(nums);
    }
}
}
