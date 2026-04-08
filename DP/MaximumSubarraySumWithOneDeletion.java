import java.util.Arrays;

public class MaximumSubarraySumWithOneDeletion {
  //lc-1186. Maximum Subarray Sum with One Deletion
  class Solution {
    public int cadane(int[] arr,int i,int k,int curr){
        if(i==arr.length)return curr == 0 ? Integer.MIN_VALUE : curr;
        int skip=0;
        int newcurr;
        if(curr+arr[i]<=arr[i]){
            k=1;
            newcurr=arr[i];  
        }else{
            newcurr=curr+arr[i];
        }
        if(k>0) skip=cadane(arr,i+1,k-1,curr);
        int take=cadane(arr,i+1,k,newcurr);
        return Math.max(newcurr,Math.max(skip,take));
    }
    public int tle(int[] arr){
        int sum= cadane(arr,0,1,0);
        return sum;
    }
    public int solve(int[] arr,int i,int k,int[][] dp){
        if(i==arr.length)return Integer.MIN_VALUE;
        if(dp[i][k]!=-1)return dp[i][k];
        //start at same idx
        int start=arr[i];

        //extend next only if valid
        int extendNext = solve(arr, i + 1, k, dp);
    int extend = (extendNext == Integer.MIN_VALUE) ? arr[i] : arr[i] + extendNext;

        //delete
        int delete=Integer.MIN_VALUE;
        if(k>0){
            delete=solve(arr,i+1,k-1,dp);
        }
        return dp[i][k]= Math.max(start,Math.max(extend,delete));

    }
    public int rec(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n][2];
        for(var row:dp)Arrays.fill(row,-1);
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(arr, i, 1, dp));
        }
        return ans;
    }
    public int tabulation(int[] arr){
        int n=arr.length;
        int nodeletion=arr[0];
        int deletion=0;
        int ans=arr[0];
        for(int i=1;i<n;i++){
            //fresh start
            int start=arr[i];
            //extend next
            int extend=nodeletion+arr[i];
            //delete this;
            int skip=nodeletion;
            // extend a previously deleted subarray
            int delete =  deletion + arr[i];
            
            nodeletion=Math.max(start,extend);
            deletion=Math.max(skip,delete);
            ans=Math.max(ans,Math.max(nodeletion,deletion));
        }
        return ans;
    }
    public int maximumSum(int[] arr) {
        // return rec(arr);
        return tabulation(arr);
    }
}
  
}