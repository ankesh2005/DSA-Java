package DSU;

public class IncrementalEvenWeightedCycleQueries {
  // lc-3887 Incremental Even-Weighted Cycle Queries
    public int find(int u,int[] parent,int[] parity){
        if(parent[u]!=u){
            int op=parent[u];
            int root=find(parent[u],parent,parity);
            parity[u]^=parity[op];
            parent[u]=root;
        }
        return parent[u];
    }
    int res;
    public void union(int u,int v,int[] parent,int[]size,int[] parity,int w){
        int pu=find(u,parent,parity);
        int pv=find(v,parent,parity);
        if(pu!=pv){
            if(size[pu]>size[pv]){
                parent[pv]=pu;
                size[pu]+=size[pv];
                parity[pv]=parity[v]^parity[u]^w;
                res++;
            }else{
                parent[pu]=pv;
                size[pv]+=size[pu];
                parity[pu]=parity[v]^parity[u]^w;
                res++;
            }
        }
        else{
            if((parity[u]^parity[v]^w)==0){
                res++;
            }
        }
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {
        res=0;
        int parent[]=new int[n];
        int size[]=new int[n];
        int parity[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            parity[i]=0;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            union(u,v,parent,size,parity,w);
        }
        return res;
    }
}
