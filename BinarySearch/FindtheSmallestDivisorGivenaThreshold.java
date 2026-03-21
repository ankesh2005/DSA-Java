package BinarySearch;

public class FindtheSmallestDivisorGivenaThreshold {
  // lc-1283. Find the Smallest Divisor Given a Threshold
   public boolean divisor(int[] nums,int div,int thresh){
        int sum=0;
        for(int num:nums){
            sum+=Math.ceil(num*1.0/div);
        }
        return sum<=thresh;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int lo=1,hi=max;
        int ans=max;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(divisor(nums,mid,threshold)){
                hi=mid-1;
                ans=mid;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}
