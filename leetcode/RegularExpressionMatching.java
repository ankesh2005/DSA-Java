public class RegularExpressionMatching {
  // lc-10. Regular Expression Matching
  class Solution {
    static int dp[][];
    public boolean check(String s,String p,int i,int j){
        if(p.length()==j){
   return (dp[i][j] = (s.length()==i)?1:0) == 1;
}

        boolean charmatch=false;
        if(dp[i][j]!=-1)return dp[i][j]==1;
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
    charmatch = true;
        if(j + 1 < p.length() && p.charAt(j+1)=='*'){
            boolean nottake=check(s,p,i,j+2);
            boolean take= charmatch && check(s,p,i+1,j);
            dp[i][j]=(take||nottake)?1:0;
            return take||nottake;
        }
        boolean ot=charmatch&&check(s,p,i+1,j+1);
        dp[i][j]=(ot)?1:0;
        return ot;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++)dp[i][j]=-1;
        }
        return check(s,p,0,0);

    }
}
}