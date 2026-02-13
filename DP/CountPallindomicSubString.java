public class CountPallindomicSubString {
  class Solution {
    public int countPS(String s) {
        // code here
        int n=s.length();
        int[][] dp=new int[n][n];
        int ans=0;
        for(int i=0;i<n;i++){
            int row=0;
            for(int col=i;col<n;col++,row++){
                if(row==col) dp[row][col]=1;
                else if(s.charAt(row)==s.charAt(col)){
                    if(row+1==col) dp[row][col]=2;
                    else if(dp[row+1][col-1]!=0) dp[row][col]=2+dp[row+1][col-1];
                }
                if(dp[row][col]>=2) ans++;
            }
        }
        return ans;
    }
}
}
