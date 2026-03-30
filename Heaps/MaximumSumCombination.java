package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximumSumCombination {
    private void reverse(int[] arr) {
    int l = 0, r = arr.length - 1;
    while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
    }
}
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        reverse(a);
        Arrays.sort(b);
        reverse(b);
        int m=a.length;
        int n=b.length;
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0]));
        HashSet<String>visited=new HashSet<>();
        pq.add(new int[]{a[0]+b[0],0,0});
        visited.add("0+0");
        while(ans.size()!=k && !pq.isEmpty()){
            int[] temp=pq.poll();
            int i=temp[1];
            int j=temp[2];
            ans.add(temp[0]);
            if(i+1<m && !visited.contains((i+1)+"+"+j)){
                pq.add(new int[]{a[i+1]+b[j],i+1,j});
                visited.add((i+1)+"+"+j);
            }
            if(j+1<n && !visited.contains(i+"+"+(j+1))){
                pq.add(new int[]{a[i]+b[j+1],i,(j+1)});
                visited.add(i+"+"+(j+1));
            }
        }
        return ans;
        
        
    }
}

