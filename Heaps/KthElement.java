package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthElement {
  // maxheap
   public int kthSmallest(int[] arr, int k) {
      PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
      for (int val : arr) {
        pq.add(val);
        if(pq.size()>k)pq.remove();
      }
      return pq.peek();  
    }
    
    // lc-215 Kth Largest Element in an Array
    // minheap
    public static int KthLargest(int arr[], int k) {
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      for (int val : arr) {
        pq.add(val);
        if(pq.size()>k)pq.remove();
      }
      return pq.peek();
    }
    // nearly sorted
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(;i<arr.length;i++){
          pq.add(arr[i]);
          if(pq.size()>k){
            arr[i-k]=pq.poll();
          }
        }
        while(!pq.isEmpty()){
          arr[i-k]=pq.poll();
          i++;
        }
        
    }
}
