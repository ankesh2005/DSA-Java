package SegmentTree;

public class LongestBalancedSubarrayII {
// lc-3721. Longest Balanced Subarray II
  class Solution {
    int n;
    int segMax[],segMin[],lazy[];
    void updateRange(int idx,int start,int end,int l,int r,int val){
        if(lazy[idx]!=0){
            segMin[idx]+=lazy[idx];
            segMax[idx]+=lazy[idx];
            if(l!=r){
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx]=0;
        }
        if(l>end || r<start)return;
        if(start<=l && end>=r){
           segMin[idx]+=val;
           segMax[idx]+=val;
           if(l!=r){
            lazy[2*idx+1]+=val;
            lazy[2*idx+2]+=val;
           }
           return;
        }
        int mid=(l+r)>>1;
        updateRange(2*idx+1,start,end,l,mid,val);
        updateRange(2*idx+2,start,end,mid+1,r,val);
        segMax[idx]=Math.max(segMax[2*idx+1],segMax[2*idx+2]);
        segMin[idx]=Math.min(segMin[2*idx+1],segMin[2*idx+2]);  
    }

    int findLeftMostZero(int idx,int l,int r){
        if(lazy[idx]!=0){
            segMin[idx]+=lazy[idx];
            segMax[idx]+=lazy[idx];
            if(l!=r){
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx]=0;
        }
        if(segMin[idx]>0 ||segMax[idx]<0)return -1;
        if(l==r){
            return l;   
        }
        int mid=(l+r)>>1;
        int leftResult=findLeftMostZero(2*idx+1,l,mid);
        if(leftResult!=-1)return leftResult;
        return findLeftMostZero(2*idx+2,mid+1,r);
    }

    public int longestBalanced(int[] nums) {
        n=nums.length;
        segMax=new int[4*n];
        segMin=new int[4*n];
        lazy=new int[4*n];
        int max=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            //-1->odd  1->even
            int temp=val%2==0?1:-1;
            int prev=-1;
            if(map.containsKey(val)){
                prev=map.get(val);
            }

            if(prev!=-1){
                updateRange(0,0,prev,0,n-1,-temp);
            }
            updateRange(0,0,i,0,n-1,temp);
            int l=findLeftMostZero(0,0,n-1);//leftmost zero
            if(l!=-1){
                max=Math.max(i-l+1,max);
            }
            map.put(val,i);
        }
        return max;
    }
}
}