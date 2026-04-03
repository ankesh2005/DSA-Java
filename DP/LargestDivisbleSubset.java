import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisbleSubset {
  // lc-398. Largest Divisible Subset
  class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        int dp[]=new int[n];
        int hash[]=new int[n];
        for (int idx = 0; idx < n; idx++) {
            dp[idx] = 1;      
            hash[idx] = idx;   
        }

        int max=0,lastidx=0;
        for(int idx=1;idx<n;idx++){
            for(int prev=0;prev<idx;prev++){
                if(nums[idx]%nums[prev]==0 && (1+dp[prev])>dp[idx]){
                    dp[idx]=1+dp[prev];
                    hash[idx]=prev;
                }
            }
            if(dp[idx]>max){
                max=dp[idx];
                lastidx=idx;
            }
        }
        while(hash[lastidx]!=lastidx){
            ans.add(nums[lastidx]);
            lastidx=hash[lastidx];
        }
        ans.add(nums[lastidx]);
        return ans;
    }
}
}
