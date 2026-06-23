package SegmentTree;
public class RangeSumQuery {
  // lc-307 Range Sum Query
  class NumArray {
    int n;
    int[] seg;
    void build(int idx,int low,int high,int[] nums){
        if(low==high){
            seg[idx]=nums[low];
            return;
        }
        int mid=(low+high)>>1;
        build(2*idx+1,low,mid,nums);
        build(2*idx+2,mid+1,high,nums);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public NumArray(int[] nums) {
        n=nums.length;
        seg=new int[4*n];
        build(0,0,n-1,nums);
    }
    private void update(int idx,int low,int high,int node,int val){
        if(low==high && low==node){
            seg[idx]=val;
            return;
        }
        int mid=(low+high)>>1;
        if(node<=mid) update(2*idx+1,low,mid,node,val);
        else update(2*idx+2,mid+1,high,node,val);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    
    public void update(int index, int val) {
        update(0,0,n-1,index,val);
    }
    private int query(int idx,int low,int high,int l,int r){
        if(l<=low && high<=r){
            return seg[idx];
        }
        if(high<l || low>r)return 0;
        int mid=(low+high)>>1;
        int leftSum=query(2*idx+1,low,mid,l,r);
        int rightSum=query(2*idx+2,mid+1,high,l,r);
        return leftSum+rightSum;
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}
