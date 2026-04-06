
import java.util.Arrays;

public class MinimumSumPartition {
    public boolean fill(int idx,int target,int[] nums,int[][] dp){
        if(target==0)return true;
        if(idx==nums.length)return false;
        if(target<0)return false;
        if(dp[idx][target]!=-1)return dp[idx][target]==1;
        boolean res=fill(idx+1,target-nums[idx],nums,dp)||fill(idx+1,target,nums,dp);
        dp[idx][target]=res?1:0;
        return res;
        
    }
    public int minDifference1(int nums[]) {
        int n=nums.length;
        int sum=0;
        for(var num:nums)sum+=num;
        int[][] dp=new int[n][sum+1];
        for(var row:dp)Arrays.fill(row,-1);
        for(int i=0;i<n;i++)dp[i][0]=1;
        for(int target=1;target<=sum;target++){
            fill(0,target,nums,dp);
        }
        int ans=sum;
        for(int j=0;j<=sum;j++){
            if(dp[0][j]==1)ans=Math.min(ans,Math.abs(j-(sum-j)));
        }
        return ans;
    }
    public int minDifference(int nums[]){
        int n=nums.length;
        int sum=0;
        for(var num:nums)sum+=num;
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=sum)dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean skip=dp[i-1][target];
                boolean take=false;
                if(nums[i]<=target)take=dp[i-1][target-nums[i]];
                dp[i][target]=skip||take;
            }
        }
        int ans=sum;
        for(int j=0;j<sum;j++){
            if(dp[n-1][j])ans=Math.min(ans,Math.abs(sum-2*j));
        }
        return ans;
    }
}

