package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
  // lc-1011. Capacity To Ship Packages Within D Days
  class Solution {
    public int days(int []weights,int capacity){
        int days=1;
        int c=capacity;
        for(int ele:weights){
            if(c>=ele){
                c-=ele;
            }else{
                days++;
                c=capacity-ele;
            }
        }
        return days;

    }
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int ans;int sum=0;
        for(int ele:weights){
            max=Math.max(ele,max);
            sum+=ele;
        }
        int lo=max;int hi=sum;
        ans=sum;
        while(lo<=hi){
            int mid=(hi+lo)/2;
            if(days(weights,mid)<=days){
                hi=mid-1;
                ans=mid;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}

}
