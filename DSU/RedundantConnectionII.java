package DSU;

import java.util.Arrays;

public class RedundantConnectionII {
  // lc-685. Redundant Connection II
  class Solution {
    public int leader(int u, int[] parent) {
        if (parent[u]  == u)
            return u;
        return parent[u] = leader(parent[u], parent);
    }

    public void union(int u,int v,int[] parent,int[] size){
        u=leader(u, parent);
        v=leader(v, parent);
        if(u != v){
            if(size[u] > size[v]){
                size[u] += size[v];
                parent[v] = parent[u];
            }else{
                size[v] += size[u];
                parent[u] = parent[v];
            }
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        // finding node with two parents
        int b1=-1,b2=-1;
        int[] indegree=new int[n+1];
        Arrays.fill(indegree,-1);
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(indegree[v]==-1){
                indegree[v]=i;
            }else{
                b1=indegree[v];//phla edge ki postion
                b2=i;//dusre edge ki postion
                break;
            }
        }
        //suppose b2 is redundant term so we check if without b2 cycle formed or not
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(b2==i)continue;
            if(leader(u,parent)==leader(v,parent)){
                if(b1==-1){//eska matlb hme bina 2 parent vala cycle  mila
                    return edges[i];
                }
                else return edges[b1];//cycle + 2 parnets
            }
            union(u,v,parent,size);
        }
        return edges[b2];//no cycle but 2 parents
    }
}
}
