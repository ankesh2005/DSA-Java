import java.util.Arrays;

public class JumpGame1{
  // lc-55. Jump Game 1
  class Solution {
    public boolean jump(int[] nums,int idx,int[] dp){
        int n=nums.length;
        if(idx>=n-1)return true;
        if(dp[idx]!=-1)return dp[idx]==1;
        for(int i=1;i<=nums[idx];i++){
            if(jump(nums,idx+i,dp)){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }
    public boolean jump2(int[] nums){
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
    public boolean jump3(int[] nums){
        int maxreach=0;
        int i=0;
        while(i<=maxreach){
            if(maxreach>=nums.length-1)return true;
            maxreach=Math.max(maxreach,i+nums[i]);
            i++;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        int[] dp=new int[10001];
        Arrays.fill(dp,-1);
        // return jump(nums,0,dp);
        // return jump2(nums);
        return jump3(nums);
    }
}
}