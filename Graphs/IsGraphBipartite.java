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

// dsu 
class Solution {
    public int find(int i,int[] parent){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i],parent);
    }
    public void union(int u,int v,int[] parent,int[] size,boolean[] parity){
        int leaderU=find(u,parent);
        int leaderV=find(v,parent);
        if(leaderU!=leaderV){
            if(size[leaderU]>size[leaderV]){
                size[leaderU]++;
                parent[leaderV]=leaderU;
                parity[v]=!parity[u];
            }else{
                size[leaderV]++;
                parent[leaderU]=leaderV;
                parity[u]=!parity[v];
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] parent=new int[n];
        int[] size=new int[n];
        boolean[] parity=new boolean[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            parity[i]=false;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int u=i;
                int v=graph[i][j];
                if(u<v){
                    if(find(u,parent)==find(v,parent)){//cycle detected
                        if(parity[u]==parity[v])return false;//odd length pairty
                    }
                    else{
                        union(u,v,parent,size,parity);
                    }
                }
            }
        }
        return true;
        
    }
}