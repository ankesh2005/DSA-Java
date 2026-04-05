package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
  // lc-974. Subarray Sums Divisible by K
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int[] pre=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)pre[0]=nums[0];
            else{
                pre[i]=nums[i]+pre[i-1];
            }
        }
        Map<Integer,Integer>mp=new HashMap<>();
        int ans=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            int rem=(pre[i]%k+k)%k;
            if(mp.containsKey(rem))ans+=mp.get(rem);
            mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}
  