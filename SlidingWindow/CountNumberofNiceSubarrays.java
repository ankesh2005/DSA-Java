package SlindingWindow;
public class CountNumberofNiceSubarrays {
  // lc-1248 Count Number of Nice Subarrays
  class Solution {
    public int helper(int[] nums,int k){
int ans=0;
        int r=0,l=0;
        int cOdd=0;
        int n=nums.length;
        while(r<n){
           if(nums[r]%2!=0)cOdd++;
           while(l<n && cOdd>k){
            if(nums[l]%2!=0)cOdd--;
            l++;
           }
           r++;
           ans+=(r-l);
        }
         return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
       
    }
}
}
