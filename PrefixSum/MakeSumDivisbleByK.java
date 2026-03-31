 package PrefixSum;

import java.util.HashMap;
import java.util.Map;

class MakeSumDivisbleByK {
// lc-1590. Make Sum Divisble by K
class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int num:nums)sum=(sum+num)%p;
        int rem=(int)sum%p;
        if(rem==0)return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int curr=0;
        map.put(0,-1);
        int n=nums.length;
        int ans=n;
        for(int i=0;i<n;i++){
            curr=(curr+nums[i])%p;
            int target=(curr-rem+p)%p;
            if(map.containsKey(target)){
                ans=Math.min(ans,i-map.get(target));
            }
            map.put(curr,i);
        }
        return ans==n?-1:ans;

    }
}
  
}