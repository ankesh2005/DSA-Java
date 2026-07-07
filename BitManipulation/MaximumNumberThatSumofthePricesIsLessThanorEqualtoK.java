public class MaximumNumberThatSumofthePricesIsLessThanorEqualtoK {
  // lc-3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K
  class Solution {
    long[] bits;
    public void bitsCount(long num){
        if(num==0)return;
        if(num==1){
            bits[0]+=1;
            return;
        }
        if(num==2){
            bits[0]+=1;
            bits[1]+=1;
            return;
        }
        int bitlen = 63 - Long.numberOfLeadingZeros(num);
        long nearPow2=(1L<<bitlen);
        bits[bitlen]+=num-nearPow2+1;
        for(int i=bitlen-1;i>=0;i--){
            bits[i]+=nearPow2/2;
        }
        bitsCount(num-nearPow2);
        
    }
    public long findMaximumNumber(long k, int x) {
        long best=0;
        long high=(long)1e15;
        long low=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            bits=new long[65];
            bitsCount(mid);
            long place=0;
            for(int i=0;i<65;i++){
                if((i+1)%x==0){
                    place+=bits[i];
                }
            }
            if(place<=k){
                best=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return best;
    }
}
}

