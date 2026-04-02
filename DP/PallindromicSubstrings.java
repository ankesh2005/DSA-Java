public class PallindromicSubstrings {
  // lc-647. Palindromic Substrings
  class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int ans=0;
        for(int k=0;k<n;k++){
            int i=0,j=k;
            int len=j-i+1;
            while(j<n){
                if(i==j){
                    dp[i][j]=1;
                    ans++;
                }
                else if(len==2){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=1;
                        ans++;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]==1){
                            ans++;
                            dp[i][j]=1;
                        }
                    }
                }
                i++;j++;
            }
        }
        return ans;
    }
}
}
