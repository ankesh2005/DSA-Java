package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberofEventsThatCanBeAttended {
  // lc-1353. Maximum Number of Events That Can Be Attended
  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> {
      return Integer.compare(a[0], b[0]);
    });
    int day = events[0][0];
    int j = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int n = events.length, cnt = 0;
    while (j < n || pq.size() > 0) {
      while (j < n && day == events[j][0]) {
        pq.offer(events[j][1]);
        j++;
      }
      while (pq.size() > 0 && pq.peek() < day)
        pq.poll();
      if (pq.size() > 0) {
        cnt++;
        pq.poll();
      }
      day++;
    }
    return cnt;
  }
}
