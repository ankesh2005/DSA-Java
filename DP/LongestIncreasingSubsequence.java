import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // lc-300 Longest Increasing Subsequence
  class Solution {
    static int  helper(int i,int prev,int[] arr,int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip=helper(i+1,prev,arr,dp);
        if(prev!=-1 && arr[i]<=arr[prev]) return dp[i][prev+1] =skip;
        int pick=1+helper(i+1,i,arr,dp);
        return dp[i][prev+1]=Math.max(pick,skip);
    }
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        // int[][] dp=new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(0,-1,arr,dp);
        
        // int dp[]=new int[n];
        // dp[0]=1;
        // for(int i=1;i<n;i++){
        //     int max=0;
        //     for(int j=i;j>=0;j--){
        //         if(arr[i]>arr[j]){
        //             max=Math.max(max,dp[j]);
        //         }
        //     }
        //     dp[i]=1+max;
        // }
        // int ans=0;
        // for(int val:dp){
        //     ans=Math.max(val,ans);
        // }
        // return ans;

 ArrayList<Integer> ans=new ArrayList<>();
        for(int e:arr){
            if(ans.size()==0 || ans.get(ans.size()-1)<e) ans.add(e);
            else{
                replace(ans,e);
            }
        }
        return ans.size();
    }
    private static void replace(ArrayList<Integer> ans,int e){
        int lb=-1;
        int f=0;
        int h=ans.size()-1;
        while(f<=h){
            int mid=(f+h)/2;
            if(ans.get(mid)>=e){
                lb=mid;
                h=mid-1;
            }else{
                f=mid+1;
            }
        }
        ans.set(lb,e);

    }
    class Solution1 {
    int solve(int idx,int prev,int[] nums,int[][] dp){
        if(idx==nums.length)return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        int skip=solve(idx+1,prev,nums,dp);
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+solve(idx+1,idx,nums,dp);
        }
        return dp[idx][prev+1]=Math.max(take,skip);

    }
    int rec(int[] nums){
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(var row:dp)Arrays.fill(row,-1);
        return solve(0,-1,nums,dp);
    }
    int tabular(int[] nums){
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int prev=0;prev<=n;prev++){
            dp[n][prev]=0;
        }
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=idx-1;prev>=-1;prev--){
                int skip=dp[idx+1][prev+1];
                int take=0;
                if(prev==-1 || nums[idx]>nums[prev]){
                    take=1+dp[idx+1][idx+1];
                }
                dp[idx][prev+1]=Math.max(take,skip);
            }
        }
        return dp[0][0];
    }
    int binarySearch(int[] nums){
        ArrayList<Integer>temp=new ArrayList<>();
        for(int num:nums){
            if(temp.size()==0 || temp.get(temp.size()-1)<num){
                temp.add(num);
            }else{
                int lb=-1;
                int l=0,r=temp.size()-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(temp.get(mid)>=num){
                        lb=mid;
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
                temp.set(lb,num);
            }
        }
        return temp.size();
    }
    public int lengthOfLIS(int[] nums) {
        // return rec(nums);
        // return tabular( nums);
        return binarySearch(nums);
    }
}
}
}
