public class SubarrayProductLessThanK {
  // lc-713. Subarray Product Less Than K
  class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        int r=0,l=0;
        int n=nums.length;
        int prod=1;
        if(k<=1)return 0;
        while(true){
            if(prod<k){
                if(r<n){
                    prod*=nums[r];
                    r++;
                }else break;
            }else{
                if(l<n){
                    prod/=nums[l];
                    l++;
                }else break;
            }
            if(prod<k){
                ans+=(r-l);
            }
        }
        return ans;
    }
}
}
