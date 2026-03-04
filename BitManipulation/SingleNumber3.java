public class SingleNumber3 {
  // lc-260. Single Number III
  class Solution {
    public int[] singleNumber(int[] nums) {
        int n=0;
        for(int num:nums){
            n=n^num;
        }
        int mask=(n&(n-1))^n;
        int d1=0,d2=0;
        for(int num:nums){
            if((mask&num)!=0)d1=d1^num;
            else d2=d2^num;
        }
        return new int[]{d1,d2};
    }
}
}
