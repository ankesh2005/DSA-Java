import java.util.Arrays;
public class FibonacciSeries{
  static int[] dp=new int[100];

  private static int nthFibonacci(int n){
    if(n<=1) return n;
    if(dp[n]!=-1) return dp[n];
    int ans=nthFibonacci(n-1)+nthFibonacci(n-2);
    dp[n]=ans;
    return ans;
  }
  private static void fibonacciSeries(int n){
    for(int i=0;i<n;i++){
      System.out.print(nthFibonacci(i)+" ");
    }
  }

  public static void main(String[] args){
    Arrays.fill(dp,-1);
    System.out.println(nthFibonacci(1));
    fibonacciSeries(45);
    // tc- 2*n-1 ---> O(n)
    // sc- 0(n) 
  }

}