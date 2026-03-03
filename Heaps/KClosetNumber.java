package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
// lc-658. Find K Closest Elements
class Pair implements Comparable<Pair> {
  int dis;
  int point;
  Pair(int dis,int point){
    this.dis=dis;
    this.point=point;
  }
  public int compareTo(Pair p){
    if(this.dis==p.dis)return p.point-this.point;
    return this.dis-p.dis;
  }
}

public class KClosetNumber {
  int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:arr){
          if(ele==x)continue;
          pq.add(new Pair(Math.abs(x-ele), x));
          if(pq.size()>k)pq.remove();
        }
        int ans[]=new int[k];
        while (pq.size()>0) {
          ans[--k]=pq.poll().point;
        }
        return ans;
        
    }
}
