package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TaskScheduler {
  //lc-621. Task Scheduler
  public int leastInterval1(char[] tasks, int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] map=new int[26];
        for(int i=0;i<tasks.length;i++){
            map[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++){
            if(map[i]>0)pq.add(map[i]);
        }
        int time=0;
        while(!pq.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int  i=1;i<=n+1;i++){
                if(pq.size()>0){
                    int freq=pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)>0)pq.add(temp.get(i));
            }
            if(pq.isEmpty()){
                time+=temp.size();
            }else{
                time+=n+1;
            }
        }
        return time;
    }
}
