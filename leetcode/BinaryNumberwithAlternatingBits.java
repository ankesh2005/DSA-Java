public class BinaryNumberwithAlternatingBits {
  //lc-693
  class Solution {
    public boolean hasAlternatingBits(int n) {
        int x=n;
        int prev=-1;
        while(x>0){
            int carry=x%2;
            if(prev==carry) return false;
            prev=carry;
            x=x/2;
        }
        return true;

    }
}
}
