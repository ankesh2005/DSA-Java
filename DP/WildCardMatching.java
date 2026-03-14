public class WildCardMatching{
  // lc-44 wildcard matching
  class Solution {
    static int dp[][];
    public boolean check(String s,String p,int i,int j){
        if(j<0)return i<0;
        if (i < 0) {                          
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)return dp[i][j]==1;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            boolean ans=check(s,p,i-1,j-1);
            dp[i][j]=ans?1:0;
            return ans;
        }
        if( p.charAt(j)=='*'){
            boolean take= check(s,p,i-1,j);
            boolean skip=check(s,p,i,j-1);
            dp[i][j]=(take||skip)?1:0;
            return take||skip;
        }
        else return false;
    }
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        //dp=new int[m+1][n+1];
        // for(int i=0;i<=m;i++){
        //     for(int j=0;j<=n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return check(s,p,s.length()-1,p.length()-1);
        return check2(s,p);
    }
    public boolean check2(String s,String p){
        int m=s.length(),n=p.length();
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1)=='*')dp[0][j]=dp[0][j-1];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if((p.charAt(j-1)=='?')||(p.charAt(j-1)==s.charAt(i-1))){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j - 1) == '*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[m][n];


    }
}
}