public class LongestBiotonicSubsequence {
  class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int dp1[]=new int[n];
        dp1[0]=1;
        int dp2[]=new int[n];
        dp2[n-1]=1;
        for(int i=1;i<n;i++){
            int m=0;
            for(int j=i;j>=0;j--){
                if(nums[i]>nums[j]){
                    m=Math.max(m,dp1[j]);
                }
            }
            dp1[i]=m+1;
        }
        for(int i=n-2;i>=0;i--){
            int m=0;
            for(int j=i;j<n;j++){
                if(nums[i]>nums[j]){
                    m=Math.max(m,dp2[j]);
                }
            }
            dp2[i]=m+1;
        }
        int maxLen=0;
        for(int i=0;i<n;i++){
            if(dp1[i]!=1 && dp2[i]!=1)
            maxLen=Math.max(maxLen,dp1[i]+dp2[i]-1);
        }
        return maxLen;
    }
}

}
