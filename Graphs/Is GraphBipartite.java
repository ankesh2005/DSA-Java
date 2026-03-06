package Graphs;

public class IsGraphBipartite {
  // lc-785 Is Graph Bipartite?
class Solution {
    static boolean ans;
    public void bfs(int i,int[][] graph,int[] visit){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(i);
        visit[i]=0;
        while(!q.isEmpty()){
            int front=q.remove();
            int color=visit[front];
            for(int adj:graph[front]){
                if(visit[adj]==-1){
                    visit[adj]=1-color;
                    q.add(adj);
                }else if(visit[adj]==color){
                    ans=false;
                    return;
                }
                
            }
        }
    }
    public boolean dfs(int i,int col,int[][] graph,int[] visit){
       visit[i]=col;
        for(int ele:graph[i]){
            if(visit[ele]==-1){
                if(!dfs(ele,1-visit[i],graph,visit))return false;
            }
            else if(visit[i]==visit[ele])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int visit[]=new int[graph.length];
        Arrays.fill(visit,-1);//-1->unvisit 0->blue 1->red
        ans=true;
        for(int i=0;i<graph.length;i++){
            if(visit[i]==-1){
                // if(ans==false)break;
                // bfs(i,graph,visit);
                if(!dfs(i,0,graph,visit))return false;
            }
        }
        // return ans;
        return true;
    }
}
}
