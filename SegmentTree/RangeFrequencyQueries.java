package SegmentTree;

public class RangeFrequencyQueries {
// lc-2080. Range Frequency Queries
class RangeFreqQuery {
    int n;
    Map<Integer,Integer>[] seg;
    public RangeFreqQuery(int[] arr) {
        n=arr.length;
        seg=new HashMap[4*n];
        build(0,0,n-1,arr);
    }
    void build(int idx,int left,int right,int[] arr){
        seg[idx]=new HashMap<>();
        if(left==right){
            seg[idx].put(arr[left],1);
            return;
        }
        int mid=(left+right)>>1;
        build(2*idx+1,left,mid,arr);
        build(2*idx+2,mid+1,right,arr);
        seg[idx].putAll(seg[2*idx+1]);
        for(int key:seg[2*idx+2].keySet()){
            seg[idx].put(key,seg[idx].getOrDefault(key,0)+seg[2*idx+2].get(key));
        }
    }
    
    private int query(int idx,int left,int right,int l,int r,int value){
        if(left>=l && right<=r){
            return seg[idx].getOrDefault(value,0);
        }
        if(right< l|| left>r)return 0;

        int mid=(left+right)>>1;
        int lside=query(2*idx+1,left,mid,l,r,value);
        int rside=query(2*idx+2,mid+1,right,l,r,value);
        return lside+rside;
    }
    public int query(int left, int right, int value) {
        return query(0,0,n-1,left,right,value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
  
}