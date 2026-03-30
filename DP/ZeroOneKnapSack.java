import java.util.Arrays;

public class ZeroOneKnapSack {
  class Solution {
    private int helper(int idx,int W,int val[],int wt[]){
        if(idx==val.length){
            if(W>=0) return 0;
            else return Integer.MIN_VALUE;
        }
        int pick=val[idx]+helper(idx+1,W-wt[idx],val,wt);
        int skip=helper(idx+1,W,val,wt);
        return Math.max(pick,skip);
        
    }
    public int solve(int W,int[] val,int[] wt,int[][] dp,int idx){
        if(idx==0){
            if(wt[idx]<=W)return val[idx];
            else return 0;
        }
        if(dp[idx][W]!=-1)return dp[idx][W];
        int skip=solve(W,val,wt,dp,idx-1);
        int take=Integer.MIN_VALUE;
        if(wt[idx]<=W)take=val[idx]+solve(W-wt[idx],val,wt,dp,idx-1);
        return dp[idx][W]=Math.max(skip,take);
    }
    public int rec(int W,int[] val,int[] wt){
        int dp[][]=new int[val.length][W+1];
        for(var row:dp)Arrays.fill(row,-1);
        return solve(W,val,wt,dp,val.length-1);
    }
    int tabular(int W,int val[],int wt[]){
        int n=val.length;
        int dp[][]=new int[n][W+1];
        for(int i=wt[0];i<=W;i++)dp[0][i]=val[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int skip=dp[i-1][j];
                int take=Integer.MIN_VALUE;
                if(wt[i]<=j)take=val[i]+dp[i-1][j-wt[i]];
                dp[i][j]=Math.max(skip,take);
            }
        }
        return dp[n-1][W];
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        // return helper(0,W,val,wt);
        //   return rec(W,val,wt);
        // return tabular(W,val,wt);
        int n=val.length;
        int[][] dp=new int[n+1][W+1];
        // List<int[]> pairs=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     pairs.add(new int[]{wt[i],val[i]});
        // }
        // pairs.sort((a,b)->Integer.compare(a[0],b[0]));
        // for(int i=0;i<n;i++){
        //     wt[i]=pairs.get(i)[0];
        //     val[i]=pairs.get(i)[1];
        // }
        for(int i=1;i<=n;i++){
            for(int w=1;w<=W;w++){
                if(wt[i-1]<=w){
                    dp[i][w]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
                }else{
                    dp[i][w]=dp[i-1][w];
                }
                
            }
        }
        return dp[n][W];
    }
}

}
