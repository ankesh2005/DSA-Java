package Greedy;

public class JumpGameII {
  // lc-45 Jump Game II
  class Solution {
    int solve(int idx,int[] nums,int[] dp){
        int n=nums.length;
        if(idx>=n-1)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int jumps=nums[idx];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=jumps;i++){
            int next=solve(idx+i,nums,dp);
            if(next!=Integer.MAX_VALUE){
                min=Math.min(next+1,min);
            }
        }
        return dp[idx]=min;
    }
    int memo(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
    int tabular(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=0;
        for(int idx=n-2;idx>=0;idx--){
            int jumps=nums[idx];
            int min=Integer.MAX_VALUE;
            for(int step=1;step<=jumps && step+idx<n;step++){
                int next=dp[idx+step];
                if(next!=Integer.MAX_VALUE){
                    min=Math.min(min,next+1);
                }
            }
            dp[idx]=min;
        }
        return dp[0];
    }
    public int greedy(int[] nums){
        int jumps=0,l=0,r=0;
        while(r<nums.length-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            jumps++;
            l=r+1;
            r=farthest;
        }
        return jumps;
    }
    public int jump(int[] nums) {
        // return memo(nums);
        // return tabular(nums);
        return greedy(nums);
    }
}
}