public package BreadthFirstSearch;

class MinimumHeightTrees {
// lc-310. Minimum Height Trees
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         if (n == 1) return Collections.singletonList(0);
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int[] indeg=new int[n];
        boolean[] visit=new boolean[n];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indeg[u]+=1;
            indeg[v]+=1;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==1){
                q.add(i);
            }

        }
        while(n>2){
            int size=q.size();
            n-=size;
            for(int i=0;i<size;i++){
                int u=q.poll();
                for(int v:adj.get(u)){
                    indeg[v]--;
                    if(indeg[v]==1){
                        q.add(v);
                    }
                }
            }
        }
        return new ArrayList<>(q);

    }
}
  
}