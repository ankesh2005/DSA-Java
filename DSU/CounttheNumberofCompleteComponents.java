public class CounttheNumberofCompleteComponents {
// lc-2685. Count the Number of Complete Components
class Solution {
    int find(int u,int[] parent){
        if(u!=parent[u]){
            return parent[u]=find(parent[u],parent);
        }
        return u;
    }
    void union(int u,int v,int parent[],int size[],int[] edges){
        int parentU=find(u,parent);
        int parentV=find(v,parent);
        if (parentU == parentV) {
            edges[parentU]++;
            return;
        }
        if(size[parentU]>=size[parentV]){
            size[parentU]+=size[parentV];
            parent[parentV]=parentU;
            edges[parentU]+=edges[parentV]+1; 
        }else{
            size[parentV]+=size[parentU];
            parent[parentU]=parentV;
            edges[parentV]+=edges[parentU]+1;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int[] size=new int[n];
        int parent[]=new int[n];
        int[] edgeCount=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
            edgeCount[i] = 0;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            union(u,v,parent,size,edgeCount);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                int cs=size[i];
                int req=cs*(cs-1)/2;
                if(edgeCount[i]==req){
                    count++;
                }
            }
        }
        return count;

    }
}
  
}