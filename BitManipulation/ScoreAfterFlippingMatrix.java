public class ScoreAfterFlippingMatrix {
  // 861. Score After Flipping Matrix
  class Solution {
    private void flip(int row,int[][] grid){
        int col=grid[row].length;
        for(int j=0;j<col;j++){
            if(grid[row][j]==0){
                grid[row][j]=1;
            }else{
                grid[row][j]=0;
            }
        }
    }
    public int matrixScore(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            if(grid[i][0]==0){
                flip(i,grid);
            }
        }
        int n=col-1;
        int ans=row*(1<<n);
        n--;
        for(int j=1;j<col;j++){
            int ones=0;
            for(int i=0;i<row;i++){
                if(grid[i][j]==1)ones++;
            }
            ones=Math.max(ones,row-ones);
            ans+=ones*(1<<n);
            n--;
        }
        return ans;
    }
}
}
