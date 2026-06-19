import java.util.Arrays;

public class FruitsIntoBasketsIII {
  // lc-3479. Fruits Into Baskets III
  class Solution {
    int seg[];
    void build(int idx,int l,int r,int[] baskets){
        if(l==r){
            seg[idx]=baskets[l];
            return;
        }
        int mid=(l+r)>>1;
        build(2*idx+1,l,mid,baskets);
        build(2*idx+2,mid+1,r,baskets);
        seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]); 
    }
    public boolean query(int i,int l,int r,int fruit){
        if(seg[i]<fruit){
            return false;
        }
        if(l==r){
            seg[i]=-1;
            return true;
        }
        int mid=(l+r)>>1;
        boolean place=false;
        if(seg[2*i+1]>=fruit){
            place=query(2*i+1,l,mid,fruit);
        }
        else{
            place=query(2*i+2,mid+1,r,fruit);
        }
        seg[i]=Math.max(seg[2*i+1],seg[2*i+2]);
        return place;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=baskets.length;
        seg=new int[4*n];
        Arrays.fill(seg,-1);
        build(0,0,n-1,baskets);
        int unplaced=0;
        for(int fruit:fruits){
            if(!query(0,0,n-1,fruit))unplaced++;
        }
        return unplaced;
    }
}
}
