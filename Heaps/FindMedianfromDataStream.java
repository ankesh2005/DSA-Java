package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

// lc-295. Find Median from Data Stream
public class FindMedianfromDataStream {
  class MedianFinder {
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
          maxHeap.add(num);
        }else{
          if(num>maxHeap.peek())minHeap.add(num);
          else maxHeap.add(num);
        }
        if(maxHeap.size()==minHeap.size()+2){
          minHeap.add(maxHeap.remove());
        }
        if(minHeap.size()==maxHeap.size()+2){
          maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()+1)return minHeap.peek();
        if(maxHeap.size()==minHeap.size()+1)return maxHeap.peek();
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}
}
