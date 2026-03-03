package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// lc-347. Top K Frequent Elements
public class TopKFrequentNumbers {
  public ArrayList<Integer> topKFreq(int[] arr, int k) {
    HashMap<Integer, Integer> mp = new HashMap<>();
    for (int ele : arr) {
      mp.put(ele, mp.getOrDefault(ele, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      if (mp.get(a) == mp.get(b))
        return a - b;
      else
        return mp.get(a) - mp.get(b);
    });
    for (int key : mp.keySet()) {
      pq.add(key);
      if (pq.size() > k)
        pq.remove();
    }
    ArrayList<Integer> ans = new ArrayList<>(pq);
    ans.sort((a, b) -> {
      if (mp.get(a).equals(mp.get(b)))
        return b - a;
      return mp.get(b) - mp.get(a);
    });
    return ans;
  }
}
