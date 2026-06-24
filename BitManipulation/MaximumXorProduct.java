public class MaximumXorProduct {
  // lc-2939. Maximum Xor Product
  class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int Mod=(int)1e9+7;
        long axorx=0,bxorx=0;
        for(int i=49;i>=n;i--){
            boolean aithbit=((a>>i)&1)>0;
            boolean bithbit=((b>>i)&1)>0;
            if(aithbit==true){
                axorx=(axorx^(1L<<i));
            }
            if(bithbit==true){
                bxorx=(bxorx^(1L<<i));
            }
        }
        for(int i=n-1;i>=0;i--){
            boolean aithbit=((a>>i)&1)>0;
            boolean bithbit=((b>>i)&1)>0;
            if(aithbit==bithbit){
                axorx=(axorx^(1L<<i));
                bxorx=(bxorx^(1L<<i));
                continue;
            }
            if(axorx>bxorx){
                bxorx=(bxorx^(1L<<i));
            }else{
                axorx=(axorx^(1L<<i));
            }
        }
        return (int)((axorx * 1L % Mod) * (bxorx % Mod) % Mod);
    }
}
  
}