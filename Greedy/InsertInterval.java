package Greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  //lc-57. Insert Interval
    public int[][] insert(int[][] intervals, int[] ni) {
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<ni[0]){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        int first=Math.min(ni[0],intervals[i][0]);
        int end=Math.max(ni[1],intervals[i][1]);
        while(i<n && intervals[i][0]<=end){
            first=Math.min(first,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{first,end});
        while(i<n){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

