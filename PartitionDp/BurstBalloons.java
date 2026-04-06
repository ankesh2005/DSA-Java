package PartitionDp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons {
  // lc-312. Burst Balloons
  class Solution {
    int solve(List<Integer> nums,int i,int j,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int coins=nums.get(i-1)*nums.get(k)*nums.get(j+1)+solve(nums,i,k-1,dp)+solve(nums,k+1,j,dp);
            max=Math.max(coins,max);
        }
        return dp[i][j]=max;
    }
    int rec(List<Integer> nums){
        int n=nums.size();
        int[][] dp=new int[n][n];
        for(int row[]:dp)Arrays.fill(row,-1);
        return solve(nums,1,n-2,dp);
    }
    int tabular(List<Integer> nums){
        int n=nums.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=n-2;i>=1;i--){
            for(int j=i;j<=n-2;j++){
                int max=Integer.MIN_VALUE;;
                for(int k=i;k<=j;k++){
                    int coin=nums.get(i-1)*nums.get(k)*nums.get(j+1)+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(coin,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n-2];
    }
    public int maxCoins(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for (int num : nums) list.add(num);
        list.add(0,1);
        list.add(1);
        // return rec(list);
        return tabular(list);
    }
}
}
