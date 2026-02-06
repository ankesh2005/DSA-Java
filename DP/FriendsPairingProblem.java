public class FriendsPairingProblem {
  public static long countFriendsPairings(int n) {
        // code here
        // if(n<=2) return n;
        // return countFriendsPairings(n-1)+(n-1)*countFriendsPairings(n-2);


        // long[] dp=new long[n+1];
        // return friends(n,dp);

        if(n<=2) return n;
        long[] dp=new long[3];
        dp[0]=1;
        dp[1]=2;
        dp[2]=0;
        for(int i=3;i<=n;i++){
          dp[2]=dp[1]+(i-1)*dp[0];
          dp[0]=dp[1];
          dp[1]=dp[2];
        }
        return dp[2];
    } 
    public static long friends(int n,long[] dp){
      if(n<=2) return n;
      if(dp[n]!=0) return dp[n];
      return dp[n]=friends(n-1,dp)+(n-1)*friends(n-2, dp);
    }
  public static void main(String[] args) {
    System.out.println(countFriendsPairings(4));
  }
}
