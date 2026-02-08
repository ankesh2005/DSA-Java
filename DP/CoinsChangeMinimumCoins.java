import java.util.Arrays;

public class CoinsChangeMinimumCoins {
  class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int n=coins.length;
        int[] dp=new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[0] = 0;
        for(int i=0;i<n;i++){
            for(int c=coins[i];c<=sum;c++){
                if(dp[c-coins[i]]!=Integer.MAX_VALUE){
                    dp[c]=Math.min(dp[c],1+dp[c-coins[i]]);
                }
            }
        }
        return dp[sum]==Integer.MAX_VALUE?-1:dp[sum];
    }
}
}
