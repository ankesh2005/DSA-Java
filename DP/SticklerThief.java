import java.util.Arrays;

public class SticklerThief {
  static int[] dp;
  private static int FindMaxSum(int[] arr){
    // recursion
    // return loot(0,arr);

    // dp
    dp=new int[arr.length];
    Arrays.fill(dp, -1);
    return loot(0, arr);
  }
  private static int loot(int i,int[] arr){
    // recursion
    // if(i>=arr.length) return 0;
    // int pick=arr[i]+loot(i+2,arr);
    // int skip=loot(i+1,arr);
    // return Math.max(pick, skip);

    // dp
    if(i>=arr.length) return 0;
    if(dp[i]!=-1) return dp[i];
    int pick=arr[i]+loot(i+2, arr);
    int skip=loot(i+1, arr);
    dp[i]=Math.max(pick, skip);
    return dp[i];

  }
  public static void main(String[] args) {
   System.out.println(FindMaxSum(new int[]{4,10,1,2,15})); 
  }
  
}
