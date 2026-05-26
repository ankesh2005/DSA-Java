
public class MaxElementInRange {
  int[] a = new int[100000];
  int seg[] = new int[4 * 100000];

  void build(int idx, int low, int high) {
    if(low==high){
      seg[idx]=a[low];
      return;
    }
    int mid = (low + high) / 2;
    build(2 * idx + 1, low, mid);
    build(2 * idx + 2, mid + 1, high);
    seg[idx]=Math.max(seg[2*idx+1],seg[2*idx+2]);
  }
  int maxQuery(int idx,int low,int high,int l,int r){
    if(low>=l && high<=r){
      return seg[idx];
    }
    if(high<l || low>r){
      return Integer.MIN_VALUE;
    }
    int mid=(low+high)/2;
    int leftMax=maxQuery(2*idx+1, low, mid, l, r);
    int rightMax=maxQuery(2*idx+2, mid+1, high, l, r);
    return Math.max(leftMax, rightMax);
  }

  public static void main(String[] args) {

  }
}
