import java.util.List;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
  // lc-1239. Maximum Length of a Concatenated String with Unique Characters
  class Solution {
    boolean unique(StringBuilder sb,String s){
        int[] map=new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
            if(map[ch-'a']>1)return false;
        }
        for(int i=0;i<sb.length();i++){
            int ch=sb.charAt(i)-'a';
            map[ch]++;
            if(map[ch]>1)return false;
        }
        return true;
    }
    int backtrack(List<String>arr,int i,StringBuilder sb){
        int n=arr.size();
        if(i==n)return sb.length();
        int max=sb.length();
        for(int k=i;k<n;k++){
            int len=sb.length();
            if(unique(sb,arr.get(k))){
                sb.append(arr.get(k));
                max=Math.max(max,backtrack(arr,k+1,sb));
                sb.setLength(len);
            }
        }
        return max;
    }
    public int maxLength(List<String> arr) {
        return backtrack(arr,0,new StringBuilder());
    }
}
}
