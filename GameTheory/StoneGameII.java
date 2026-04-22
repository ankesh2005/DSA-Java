package GameTheory;

import java.util.Arrays;

public class StoneGameII {
  // lc-1140. Stone Game II
  class Solution {
    int[] suffix;
    int solve(int[] piles,int idx,int M,boolean alice,int[][][] dp){
        int n=piles.length;
        if(idx>=n)return 0;
        int player=alice?1:0;
        if(dp[player][idx][M]!=-1)return dp[player][idx][M];
        if (2 * M >= n - idx) {
            return dp[player][idx][M] = alice ? suffix[idx] : 0;
        }
        int res=alice?-1:Integer.MAX_VALUE;
        int stone=0;
        for(int x=1;x<=Math.min(2*M,n-idx) ;x++){
           stone+=piles[idx+x-1];
           if(alice){
            int rembest=solve(piles,idx+x,Math.max(x,M),false,dp);
            res=Math.max(res,stone+rembest);
           }else{
            int remworst=solve(piles,idx+x,Math.max(x,M),true,dp);
            res=Math.min(res,remworst);
           }
        }
        return dp[player][idx][M]=res;
    }
    int memo(int[]piles){
        int n=piles.length;
        int dp[][][]=new int[2][n][n+1];
        for(int box[][]:dp){
            for(int[] row:box){
                Arrays.fill(row,-1);
            }
        }
        return solve(piles,0,1,true,dp);
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] + piles[i];
        return memo(piles);
    }
}
}
