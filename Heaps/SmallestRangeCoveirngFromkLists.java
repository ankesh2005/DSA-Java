
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
// lc-632. Smallest Range Covering Elements from K Lists
class Triplet implements Comparable<Triplet>{
  int val;
  int row;
  int col;
  Triplet(int val,int row,int col){
    this.col=col;
    this.row=row;
    this.val=val;
  }
  public int compareTo(Triplet t){
    return this.val-t.val;
  }
}
public class SmallestRangeCoveirngFromkLists {

  public ArrayList<Integer> findSmallestRange(int[][] mat) {
      int row=mat.length,col=mat[0].length;
      PriorityQueue<Triplet> pq=new PriorityQueue<>();//minheap
      int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
      for(int i=0;i<row;i++){
        max=Math.max(max, mat[i][0]);
        min=Math.min(min,mat[i][0]);
        pq.add(new Triplet(mat[i][0], i, 0));
      }
      int a=min,b=max;
      while(true){
        Triplet top=pq.remove();
        int val=top.val,rw=top.row,cl=top.col;
        int x=mat[rw][cl+1];
        if(max-val<b-a){
          a=val;
          b=max;
        }
        if(cl==col-1)break;
        int next=mat[row][col+1];
        Math.max(max, next);
        pq.add(new Triplet(next, row, col+1));
      }
      return new ArrayList<>(Arrays.asList(a,b));    
    }
}
