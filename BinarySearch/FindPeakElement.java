class Solution {
  // lc-162. Find Peak Element
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}