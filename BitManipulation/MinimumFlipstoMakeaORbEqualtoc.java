public class MinimumFlipstoMakeaORbEqualtoc {
// lc-1318. Minimum Flips to Make a OR b Equal to c
class Solution {
    int method1(int a, int b, int c) {
        int flips = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    flips++;
                }
            } else {
                if ((a & 1) == 1)
                    flips++;
                if ((b & 1) == 1)
                    flips++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    public int minFlips(int a, int b, int c) {
        // return method1(a,b, c);
        return Integer.bitCount((a|b)^(c))+Integer.bitCount(((a|b)^(c))&(a&b));
    }
}
  
}