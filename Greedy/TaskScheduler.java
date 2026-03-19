package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TaskScheduler{
  // lc-621. Task Scheduler
  class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for(int i=0;i<tasks.length;i++){
            map[tasks[i]-'A']++;
        }
        Arrays.sort(map);
        int maxfreq=map[25];
        int gaddhe=maxfreq-1;
        int idleslots=gaddhe*n;
        for(int i=24;i>=0;i--){
            idleslots-=Math.min(map[i],gaddhe);
        }
        if(idleslots>0){
            return tasks.length+idleslots;
        }
        return tasks.length;
    }
}
}