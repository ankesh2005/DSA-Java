package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
  // Aggressive Cows
  // lc-1552. Magnetic Force Between Two Balls
      public boolean place(int[] stalls,int k,int space){
        int pre=stalls[0];
        k--;
        int i=1;
        while(i<stalls.length && k>0){
            if(stalls[i]-pre>=space){
                k--;
                pre=stalls[i];
            }
            i++;
        }
        return k==0;
    }
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int min=stalls[0];
        int max=stalls[n-1];
        int lo=1;
        int hi=max-min;
        int ans=hi;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(place(stalls,k,mid)){
                lo=mid+1;
                ans=mid;
            }else{
                hi=mid-1;
            }
        }
        return ans;
    }
}
