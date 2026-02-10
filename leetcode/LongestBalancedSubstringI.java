public class LongestBalancedSubstringI {
  class Solution {
    private boolean isBalanced(int[] arr){
        int min=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) continue;
            if(min==0) min=arr[i];
            else if(arr[i]!=min) return false;
        }
        return true;
    }
    public int longestBalanced(String s) {
        int[] arr=new int[26];
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            arr=new int[26];
            if(max>=n-i) break;
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                if(isBalanced(arr)){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}
}
