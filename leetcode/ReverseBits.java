public class ReverseBits {
  // lc-190
  class Solution {
    public int reverseBits(int n) {
        int x=n;
        StringBuilder sb=new StringBuilder();
        int carry=0;
        while(x>0){
            carry=x%2;
            x=x/2;
            sb.append(carry == 0 ? '0' : '1');
        }
        for(int i=sb.length();i<32;i++){
            sb.append('0');
        }
        x=0;
        sb.reverse();
        for(int i=0;i<32;i++){
            int bit = sb.charAt(i) - '0';
            x=x+bit*((int)Math.pow(2,i));
        }
        return x;
    }
}
}
