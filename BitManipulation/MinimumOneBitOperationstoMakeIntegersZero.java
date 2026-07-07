public class MinimumOneBitOperationstoMakeIntegersZero {
  // lc-1611. Minimum One Bit Operations to Make Integers Zero
  class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0)return 0;
        long[] ops=new long[31];
        ops[0]=1;
        for(int i=1;i<31;i++){
            ops[i]=2*ops[i-1]+1;
        }
        int res=0;
        int flag=1;
        for(int i=30;i>=0;i--){
            boolean ithbit=((1<<i)&n)>0;
            if(ithbit){
                res=res+(int)ops[i]*flag;
                flag*=-1;
            }
        }
        return res;
    }
}
}
