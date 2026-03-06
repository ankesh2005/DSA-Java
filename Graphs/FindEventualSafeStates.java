package Graphs;

public class FindEventualSafeStates {
  //lc-802. Find Eventual Safe States
  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        // reverse indegree
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        // hans algo
        int indeg[]=new int[n];
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int ver:graph[i]){
                adj.get(ver).add(i);
                indeg[i]++;
            }
            if(indeg[i]==0)q.add(i);
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);
            for(int ver:adj.get(curr)){
                indeg[ver]--;
                if(indeg[ver]==0)q.add(ver);
            }
        }
        Collections.sort(ans);
        return ans;
        
    }
}
}
