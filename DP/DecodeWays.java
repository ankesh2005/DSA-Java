public class DecodeWays {
// lc-91 Decode Ways
  class Solution {
    int solve(int idx,String s,int[] dp){
        int n=s.length();
        if(idx==n)return 1;
        if(dp[idx]!=-1)return dp[idx];
        if(s.charAt(idx)=='0')return 0;
        int res=0;
        res+=solve(idx+1,s,dp);
        if(idx+1<n){
            String temp=s.substring(idx,idx+2);
            int num=Integer.parseInt(temp);
            if(num>=1 && num<=26){
                res+=solve(idx+2,s,dp);
            }
        }
        return dp[idx]=res;
        
    }
    int memo(String s){
        int[]dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return solve(0,s,dp);
    }
    int tabulation(String s){
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            int res=0;
            if(s.charAt(i)!='0'){
                res+=dp[i+1];
                if(i+1<n){
                    int num=Integer.parseInt(s.substring(i,i+2));
                    if(num>=1 && num<=26){
                        res+=dp[i+2];
                    }
                }
            }
            dp[i]=res;
        }
        return dp[0];
    }
    public int numDecodings(String s) {
        // return memo(s);
        return tabulation(s);
    }
}
}