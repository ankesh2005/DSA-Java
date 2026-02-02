class Solution {
    int dp[];
    private int loot(int i,int[] nums,int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+loot(i+2,nums,n);
        int skip=loot(i+1,nums,n);
        return dp[i]=Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int case1=loot(0,nums,nums.length-1);
        Arrays.fill(dp,-1);
        int case2=loot(1,nums,nums.length);
        return Math.max(case1,case2);
    }
}