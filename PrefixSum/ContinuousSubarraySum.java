package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
  // lc-523. Continuous Subarray Sum
   public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int pre[]=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int maxlen=0;
        for(int i=0;i<n;i++){
            int tar=pre[i]%k;
            if(map.containsKey(tar)){
                maxlen=Math.max(maxlen,i-map.get(tar));
                if(maxlen>=2)return true;
            }
            if(!map.containsKey(tar)){
                map.put(tar,i);
            }
        }
        return false;
    }
}
