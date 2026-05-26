package BinarySearch;

import java.util.TreeMap;
import java.util.TreeSet;

public class MyCalenderI {
  // lc-729. My Calender I
  class MyCalendar {
    TreeSet<int[]>set;
    TreeMap<Integer,Integer>map;
    public MyCalendar() {
        // set=new TreeSet<>((a,b)->a[0]-b[0]);
        map=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer floor=map.floorKey(startTime);
        if(floor!=null && map.get(floor)>startTime)return false;
        Integer ceil=map.ceilingKey(startTime);
        if(ceil!=null && ceil<endTime)return false;
        map.put(startTime,endTime);
        return true;
    }
    public boolean bookSet(int startTime, int endTime) {
        int[] newevent={startTime,endTime};
        int[] floor=set.floor(newevent);
        if(floor!=null && floor[1]>newevent[0])return false;
        int[] ceil=set.ceiling(newevent);
        if(ceil!=null && ceil[0]<newevent[1])return false;
        set.add(newevent);
        return true;
    }
}


}
