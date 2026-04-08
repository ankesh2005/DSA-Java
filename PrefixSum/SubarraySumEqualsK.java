package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
  // lc-560. Subarray Sum Equals K

    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int pre[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)pre[i]=nums[i];
            else{
                pre[i]=nums[i]+pre[i-1];
            }
        }
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int ans=0;
        for(int i=0;i<n;i++){
            int target=pre[i]-k;
            if(mp.containsKey(target))ans+=mp.get(target);
            mp.put(pre[i],mp.getOrDefault(pre[i],0)+1);
        }
        return ans;
    }
}

