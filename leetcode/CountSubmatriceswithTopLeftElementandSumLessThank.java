public class CountSubmatriceswithTopLeftElementandSumLessThank {
  //lc-3070. Count Submatrices with Top-Left Element and Sum Less Than k 
  class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] pre=new int[m][n];
        int ans=0;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0){
        //             pre[i][j]=grid[i][j];
        //         }
        //         else if(i==0){
        //             pre[i][j]=pre[i][j-1]+grid[i][j];
        //         }else if(j==0){
        //              pre[i][j]=pre[i-1][j]+grid[i][j];
        //         }
        //         else pre[i][j]=pre[i][j-1]+pre[i-1][j]-pre[i-1][j-1]+grid[i][j];
        //         if(pre[i][j]<=k)ans++;
        //     }
        // }
        int col[]=new int[n];
        for(int i=0;i<m;i++){
            int rows=0;
            for(int j=0;j<n;j++){
                col[j]+=grid[i][j];
                rows+=col[j];
                if(rows<=k)ans++;
            }
        }

        return ans;
        
    }
}
}