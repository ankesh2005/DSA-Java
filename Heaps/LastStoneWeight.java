package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
  // lc-1046. Last Stone Weight
  public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones)pq.add(stone);
        while(pq.size()>1){
          int a=pq.poll();
          int b=pq.poll();
          pq.add(Math.abs(a-b));
        }
        return pq.poll();
    }
}
