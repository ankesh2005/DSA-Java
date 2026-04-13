public class WordBreak {
// lc-139. Word Break
class Solution {
    boolean solve(int i,int j,String s,Set<String>dict,int[][] dp){
        if(j==s.length()){
            if(dict.contains(s.substring(i,j)))return true;
            else return false;

        }
        if(dp[i][j]!=-1)return dp[i][j]==1;
        boolean res1=false,res2=false,res3=false;
        //break
        if(dict.contains(s.substring(i,j+1))){
            res1=true;
            res2=solve(j+1,j+1,s,dict,dp);
        }
        //notbreak
        res3=solve(i,j+1,s,dict,dp);
        dp[i][j]=(res1&&res2)||res3?1:0;
        return dp[i][j]==1;
        
    }
    boolean memo(String s,Set<String>dict){
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        for(var row:dp)Arrays.fill(row,-1);
        return solve(0,0,s,dict,dp);
    }
    boolean tabulation(String s,Set<String>dict){
        int n=s.length();
        boolean[][] dp=new boolean[n+1][n+1];
        dp[n][n]=true;
        for(int i=0;i<n;i++){
                if(dict.contains(s.substring(i,n)))dp[i][n]=true;
                else dp[i][n]=false;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                boolean res1=false,res2=false,res3=false;
                if(dict.contains(s.substring(i,j+1))){
                    res1=true;
                    if(j+1 <= n) res2=dp[j+1][j+1];
                }
                if(j+1 <= n) res3=dp[i][j+1];
                dp[i][j]=(res1&&res2)||res3;
            }
        }
        return dp[0][0];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>dict=new HashSet<String>(wordDict);
        // return memo(s,dict);
        return tabulation(s,dict);
    }
}
  
}