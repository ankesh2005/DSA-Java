
import java.util.Arrays;

public class RodCuttingProblem {
    public int rec(int[] price,int idx,int n,int[][]dp){
        if(idx==0){
            return price[idx]*n;
        }
        if(dp[idx][n]!=-1)return dp[idx][n];
        int skip=rec(price,idx-1,n,dp);
        int cut=Integer.MIN_VALUE;
        int rodlen=idx+1;
        if(rodlen<=n)cut=price[idx]+rec(price,idx,n-rodlen,dp);
        return dp[idx][n]= Math.max(skip,cut);
    }
    public int rec(int[] price, int n){
         int dp[][]=new int[n][n+1];
        for(var row:dp)Arrays.fill(row,-1);
        return rec(price,n-1,n,dp);
    }
    public int tabular(int[] price,int n){
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];
        for(int len=0;len<=n;len++){
            prev[len]=price[0]*len;
        }
        for(int i=1;i<n;i++){
            for(int len=1;len<=n;len++){
                int skip=prev[len];
                int cut=Integer.MIN_VALUE;
                if(i+1<=len)cut=price[i]+curr[len-i-1];
                curr[len]=Math.max(skip,cut);
            }
            prev=curr;
        }
        return prev[n];
    }
    public int RodCutting(int price[], int n) {
    //    return rec(price,n);
    return tabular(price,n);
    }
}
