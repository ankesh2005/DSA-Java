package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class RearrangeString {
  // similar lc-767. Reorganize String

  class Solution {
    public static String rearrangeString(String s) {
        // code here
        int[] map=new int[26];
        for(int i=0;i<s.length();i++)map[s.charAt(i)-'a']++;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(map[i]>0){
                pq.add(new int[]{i,map[i]});
            }
        }
        if(pq.size()==1)if(pq.peek()[1]>1)return "";
        while(!pq.isEmpty()){
            ArrayList<int[]> temp=new ArrayList<>();
            for(int i=1;i<=2;i++){//since 2 adjacent cannot same we pop two element
                if(pq.size()>0){
                    int[] curr=pq.poll();
                    sb.append((char)(curr[0]+'a'));
                    curr[1]--;
                    temp.add(curr);
                }
            }
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)[1]>0)pq.add(temp.get(i));
            }
            if(pq.size()==1){
                if(pq.peek()[1]>=2)return "";
            }
        }
        return sb.toString();
        
    }
}
}
