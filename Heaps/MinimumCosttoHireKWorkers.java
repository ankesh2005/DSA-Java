package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
  //lc-857. Minimum Cost to Hire K Workers
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans=Double.MAX_VALUE;
        int n=quality.length;
        double pair[][]=new double[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=(wage[i]*1.0)/quality[i];
            pair[i][1]=quality[i];
        }
        Arrays.sort(pair,(a,b)->Double.compare(a[0],b[0]));
        PriorityQueue<Double> max=new PriorityQueue<>((a,b)->Double.compare(b,a));
        double sq=0;
        for(int i=0;i<n;i++){
            double ratio=pair[i][0];
            double qual=pair[i][1];
            sq+=qual;
            max.add(qual);
            if(max.size()>k){
                sq-=max.poll();
            }
            if(max.size()==k){
                ans=Math.min(ans,sq*ratio);
            }
        }
        return ans;
    }
}
