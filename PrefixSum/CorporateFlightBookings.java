package PrefixSum;

import java.util.Arrays;

public class CorporateFlightBookings {
  // lc-1109. Corporate Flight Bookings
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] pre=new int[n+2];
        for(int i=0;i<bookings.length;i++){
            int first=bookings[i][0];
            int last=bookings[i][1];
            int seats=bookings[i][2];
            pre[first]+=seats;
            pre[last+1]-=seats;
        }
        for(int i=1;i<n+2;i++){
            pre[i]+=pre[i-1];
        }
        return Arrays.copyOfRange(pre,1,n+1);
    }
}

