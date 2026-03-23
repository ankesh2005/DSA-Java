package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  // lc-52. Merge Intervals
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n){
            int first=intervals[i][0];
            int second=intervals[i][1];
            int j=i+1;
            while(j<n && intervals[j][0]<=second){
                second=Math.max(intervals[j][1],second);
                j++;
            }
            i=j;
            ans.add(new int[]{first,second});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

