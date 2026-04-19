package BreadthFirstSearch;

public class SimilarStringGroups {
  // lc-839. Similar String Groups
  class Solution {
    boolean isSimilar(String s1,String s2){
        int m=s1.length();
        int diff=0;
        for(int i=0;i<m;i++){
            if(s1.charAt(i)!=s2.charAt(i))diff++;
            if(diff>2)return false;
        }
        return (diff==0 || diff==2);
    }
    void dfs(int u,boolean[] vis,List<List<Integer>>adj){
        for(int v:adj.get(u)){
            if(!vis[v]){
                vis[v]=true;
                dfs(v,vis,adj);
            }
        }
    }
    void bfs(int u,boolean[] vis,List<List<Integer>>adj){
        Queue<Integer>q=new LinkedList<>();
        vis[u]=true;
        q.offer(u);
        while(!q.isEmpty()){
            u=q.poll();
            for(int v:adj.get(u)){
                if(!vis[v]){
                    vis[v]=true;
                    q.offer(v);
                }
            }
        }
    }
    public int bfsdfs(String[] strs){
        List<List<Integer>>adj=new ArrayList<>();
        int n=strs.length;
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                // dfs(i,vis,adj);
                bfs(i,vis,adj);
            }
        }
        return count;
    }
    int find(int u,int[]parent){
        if(parent[u]==u)return u;
        return parent[u]=find(parent[u],parent);
    }
    void union(int u,int v,int[] parent,int[] size){
        int leadU=find(u,parent);
        int leadV=find(v,parent);
        if(leadU==leadV)return;
        if(size[leadU]>size[leadV]){
            size[leadU]+=size[leadV];
            parent[leadV]=leadU;
        }else{
            size[leadV]+=size[leadU];
            parent[leadU]=leadV;
        }
    }
    public int numSimilarGroups(String[] strs) {
        // bfsdfs(strs);
        int n=strs.length;
        int parent[]=new int[n];
        int size[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;        
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j]) && find(i,parent)!=find(j,parent)){
                    union(i,j,parent,size);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)count++;
        }
        return count;

    }
}
  
}