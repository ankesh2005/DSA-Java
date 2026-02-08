public class UnboundKnapSack {
  class Solution {
    private int helper(int i,int c,int[] val,int[] wt,int[][]dp){
        if(i==val.length) return 0;
        if(dp[i][c]!=0) return dp[i][c];
        int skip=helper(i+1,c,val,wt,dp);
        if(c<wt[i])return dp[i][c]=skip;
        int pick=val[i]+helper(i,c-wt[i],val,wt,dp);
        return dp[i][c]=Math.max(skip,pick);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        // int[][]dp=new int[n+1][capacity+1];
        // return helper(0,capacity,val,wt,dp);
        
        int dp[]=new int[capacity+1];
        for(int i=0;i<n;i++){
            for(int c=wt[i];c<=capacity;c++){
                dp[c]=Math.max(dp[c],val[i]+dp[c-wt[i]]);
            }
        }
        return dp[capacity];
        
    }
    
}
}
