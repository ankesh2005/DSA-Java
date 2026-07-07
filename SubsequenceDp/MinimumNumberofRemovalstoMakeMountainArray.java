package SubsequenceDp;

import java.util.Arrays;

public class MinimumNumberofRemovalstoMakeMountainArray {
  // lc-1671. Minimum Number of Removals to Make Mountain Array
  class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int lis[]=new int[n];
        Arrays.fill(lis,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++ ){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[j]+1,lis[i]);
                }
            }
        }
        int[] lds=new int[n];
        Arrays.fill(lds,1);
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++ ){
                if(nums[i]>nums[j]){
                    lds[i]=Math.max(lds[j]+1,lds[i]);
                }
            }
        }
        int len=0;
        for(int i=0;i<n;i++){
            if(lds[i]>1 && lis[i]>1){
                len=Math.max(len,lds[i]+lis[i]-1);
            }
        }
        return n-len;

    }
}
  
}