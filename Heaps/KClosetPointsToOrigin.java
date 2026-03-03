import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

// lc-973. K Closest Points to Origin
class Triplet implements Comparable<Triplet> {
  int dis;
  int x;
  int y;
  Triplet(int dis,int x,int y){
    this.dis=dis;
    this.x=x;
    this.y=y;
  }
  public int compareTo(Triplet t){
    return this.dis-t.dis;
  }
}
public class KClosetPointsToOrigin {
  public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point:points){
          int x=point[0];
          int y=point[1];
          int dis=x*x+y*y;
          pq.add(new Triplet(dis,x,y));
          if(pq.size()>k)pq.remove();
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        while (!pq.isEmpty()) {
          Triplet temp=pq.poll();
          int x=temp.x;
          int y=temp.y;
          ArrayList<Integer> t=new ArrayList<>();
          t.add(x);
          t.add(y);
          ans.add(t);
        }
        return ans;
        
    }
    
}

