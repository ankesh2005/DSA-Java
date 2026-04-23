package SubsequenceDp;
public class DistinctSubsequences {
  // lc-115. Distinct Subsequences
  class Solution {
    public static int solve(String s,String t,int i,int j,int dp[][]){
        if(i>=s.length() && t.length()!=j)return 0;
        if(j==t.length())return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int skip=solve(s,t,i+1,j,dp);
        int take=0;
        if(s.charAt(i)==t.charAt(j))take=solve(s,t,i+1,j+1,dp);
        return dp[i][j]=take+skip;
    }
    public int solve2(String s,String t){
        int m=s.length(),n=t.length();
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j]=1;
                    continue;
                }else if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        // return solve(s,t,0,0,dp);
        return solve2(s,t);
    }
}
}

public String minWindow(String S, String T) {
HashMap<Character, Integer> tmap=new HashMap<>();
HashMap<Character, Integer> smap=new HashMap<>();
for(int i=0;i<T.length() ;i++){
tmap.put(T.charAt(i), tmap.getOrDefault(T.charAt(i),0)+1);

int si =- 1,ei =- 1;
int e=0, s=0;
int mlen=Integer.MAX_VALUE;
int len=S.length();
while(e<len && s<len){
smap.put(S.charAt(e), smap.getOrDefault(S.charAt(e),0)+1);
while(s<len && check(smap, tmap)){
if(mlen>e-s){
mlen=e-s;
si=s;
ei=e;

if(smap.get(S.charAt(s)) == 1){
smap. remove(S.charAt(s));
}else{
smap.put(S.charAt(s),smap.get(S.charAt(s))-1);

S++:

e++:

if(mlen == Integer.MAX_VALUE) return "No Substring";
return S.substring(si,ei+1);

}