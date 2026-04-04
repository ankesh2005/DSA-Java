package Design;

import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignEventManager {
  // lc-3885. Design Event Manager
  class EventManager {
    HashMap<Integer,Integer>map;
    PriorityQueue<int[]>pq;
    public EventManager(int[][] events) {
        map=new HashMap<>();
        pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])return a[0]-b[0];
            return b[1]-a[1];
        });
        for(var event:events){
            map.put(event[0],event[1]);
            pq.add(new int[]{event[0],event[1]});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId,newPriority);
        pq.add(new int[]{eventId,newPriority});
    }
    
    public int pollHighest() {
        while(pq.size()>0){
            int[] event=pq.poll();
            int id=event[0];
            int priority=event[1];
            if(map.containsKey(id)){
                if(map.get(id)==priority){
                    map.remove(id);
                    return id;
                }
                
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */
}
