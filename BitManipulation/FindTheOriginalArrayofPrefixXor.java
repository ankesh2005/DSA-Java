public class FindTheOriginalArrayofPrefixXor {
  // lc-2433. Find The Original Array of Prefix Xor
  class Solution {
    public int[] findArray(int[] pref) {
        int n=pref.length;
        int[] res=new int[n];
        for(int i=n-1;i>=1;i--){
            res[i]=pref[i]^pref[i-1];
        }
        res[0]=pref[0];
        return res;
    }
}
}
