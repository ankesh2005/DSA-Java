public class ConcatenationofConsecutiveBinaryNumbers {
  // lc-1680 Concatenation of Consecutive Binary Numbers
  class Solution {
    public int concatenatedBinary(int n) {
        int Mod=(int)1E9+7;
        long ans=0;
        for(int i=1;i<=n;i++){
            int length=(int)(Math.log(i)/Math.log(2))+1;
            ans=((ans<<length)%Mod+i)%Mod;
        }
        return (int)ans;
    }
}
}
