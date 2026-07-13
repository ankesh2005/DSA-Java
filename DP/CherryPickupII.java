import java.util.Arrays;

public class CherryPickupII {
  // lc-1463. Cherry Pickup II
  class Solution {
    int pick(int r1,int c1,int c2,int[][]grid,int[][][] dp){
        int rows=grid.length,cols=grid[0].length;
        if(c1<0 || c1>=cols || c2<0 || c2>=cols){
            return Integer.MIN_VALUE;
        }
        if(dp[r1][c1][c2] != -1) return dp[r1][c1][c2];
        if(r1==rows-1){
            int cherry=0;
            if(c1==c2){
                cherry+=grid[r1][c1];
            }else{
                cherry+=grid[r1][c1]+grid[r1][c2];
            }
            return dp[r1][c1][c2]=cherry;
        }
        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int best=pick(r1+1,c1+i,c2+j,grid,dp);
                if(best==Integer.MIN_VALUE){
                    continue;
                }else{
                    max=Math.max(max,best);
                }

            }
        }
        int cherry=0;
        if(c1==c2){
            cherry+=grid[r1][c1];
        }else{
            cherry+=grid[r1][c1]+grid[r1][c2];
        }
        cherry+=max;
        return dp[r1][c1][c2]=cherry;
    }
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][][] dp=new int[rows+1][cols+1][cols+1];
        for(var plane:dp){
                for(var row:plane){
                    Arrays.fill(row,-1);
                }
        }
        return pick(0,0,cols-1,grid,dp);
    }
}
}
