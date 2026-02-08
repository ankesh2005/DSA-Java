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
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        // return helper(0,W,val,wt);
        
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
