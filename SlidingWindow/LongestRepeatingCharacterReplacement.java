package SlindingWindow;

public class LongestRepeatingCharacterReplacement {
  // lc-420. Longest Repeating Character Replacement
  class Solution {
    public int characterReplacement(String s, int k) {
        int r=0,l=0;
        int maxlen=0;
        int[] arr=new int[26];
        int n=s.length();
        int maxfreq=0;

        while(r<n){
            char ch=s.charAt(r);
            arr[ch-'A']++;
            maxfreq=Math.max(maxfreq,arr[ch-'A']);
            while(l<n && (r-l+1)>maxfreq+k){
                char del=s.charAt(l);
                arr[del-'A']--;
                l++;
            }
            maxlen=Math.max(maxlen,(r-l+1));
            r++;
        }
        return maxlen;
    }
}
}
