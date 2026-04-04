package PrefixSum;

public class XORQueriesofaSubarray {
  // lc-1310. XOR Queries of a Subarray
  public int[] xorQueries(int[] arr, int[][] queries) {
        int qlen=queries.length;
        int[] ans=new int[qlen];
        int n=arr.length;
        int pre[]=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]^arr[i];
        }
        for(int i=0;i<qlen;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(l==0){
                ans[i]=pre[r];
            }else{
                ans[i]=pre[r]^pre[l-1];
            }
        }
        return ans;
    }
}
