package BinarySearch;

public class KokoEatingBananas {
//  lc-875. Koko Eating Bananas
    public boolean can(int[] piles,int cap,int h){
        int hours=0;
        for(int pile:piles){
        hours+=Math.ceil(pile*1.0/cap);
        }
        return hours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int lo=1,hi=max;
        int ans=max;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(can(piles,mid,h)){
                hi=mid-1;
                ans=mid;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
} 

