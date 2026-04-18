package DSU;

public class DisJointSetUnionBySize {
  class Solution {
    // public int find(int u,int[] parent){
    //     if(parent[u]==u)return u;
    //     return find(parent[u],parent);
    // }
    //path compression
    public int find(int u,int[] parent){
      if (parent[u]==u) {
        return u;
      }
      int leader=find(parent[u], parent);
      parent[u]=leader;
      return leader;
    }
    public void union(int u,int v,int[] parent,int[] size){
        u=find(u,parent);
        v=find(v,parent);
        if(u!=v){
          if(size[u]>size[v]){
            parent[v]=u;
            size[u]+=size[v];
          }else{
            parent[u]=parent[v];
            size[v]+=size[u];
          }
        }
    }
    public int findComponents(int[][] isConnected) {
        int n=isConnected.length;
        int[] parent=new int[n+1];
        int[] size=new int[n+1];
        for(int i=1;i<=n;i++){
          size[i]=1;
          parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i+1,j+1,parent,size);
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i)ans++;
        }
        return ans;

    }
}
}
