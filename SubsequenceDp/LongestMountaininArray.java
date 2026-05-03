package SubsequenceDp;

import java.util.Arrays;

public class LongestMountaininArray {
  // lc-845. Longest Mountain in Array
  class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int[] lis=new int[n];
        int[] lds=new int[n];
        Arrays.fill(lis,1);
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                lis[i]+=lis[i-1];
            }
        }
        Arrays.fill(lds,1);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                lds[i]+=lds[i+1];
            }
        }
        int len=0;
        for(int i=0;i<n;i++){
            if(lis[i]>1 && lds[i]>1){
                len=Math.max(lis[i]+lds[i],len);
            }
        }
        return len>3?len-1:0;
    }
}
}
