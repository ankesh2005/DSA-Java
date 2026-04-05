package Greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  //lc-57. Insert Interval
     public int[][] insert(int[][] intervals, int[] ni) {
        ArrayList<int[]> ans=new ArrayList<>();
        
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<ni[0]){
            ans.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=ni[1]){
            ni[0]=Math.min(ni[0],intervals[i][0]);
            ni[1]=Math.max(ni[1],intervals[i][1]);
            i++;
        }
        ans.add(ni);
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

