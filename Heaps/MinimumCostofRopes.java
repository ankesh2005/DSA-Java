package Heaps;

import java.util.PriorityQueue;

public class MinimumCostofRopes {
   public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int rope:arr)pq.add(rope);
        int ans=0;
        while(pq.size()>1){
          int a=pq.poll();
          int b=pq.poll();
          ans+=a+b;
          pq.add(a+b);
        }
        return ans;
    }
}
