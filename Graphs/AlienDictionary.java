package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
  class Solution {
    public String findOrder(String[] words) {
        boolean present[]=new boolean[26];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++)adj.add(new ArrayList<>());
        for(String w:words){
            for(char ch:w.toCharArray()) present[ch-'a']=true;
        }
        for(int i=0;i<words.length-1;i++){
            String w1=words[i],w2=words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
    return ""; // invalid dictionary
}
            int len=Math.min(w1.length(),w2.length());
            for(int j=0;j<len;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    int u=w1.charAt(j)-'a';
                    int v=w2.charAt(j)-'a';
                    adj.get(u).add(v);
                    break;
                }
            }
        }
        int[] indegree=new int[26];
        for(int i=0;i<26;i++){
            for(int v:adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(present[i]==true && indegree[i]==0)q.add(i);
        }
        StringBuilder order=new StringBuilder();
        while(!q.isEmpty()){
            int curr=q.poll();
            order.append((char)(curr+'a'));
            for(int v:adj.get(curr)){
                indegree[v]--;
                if(indegree[v]==0)q.add(v);
            }
        }
        int countPresent = 0;
for (boolean b : present) if (b) countPresent++;
if (order.length() < countPresent) return ""; // cycle detected
return order.toString();
        
    }
}
}
