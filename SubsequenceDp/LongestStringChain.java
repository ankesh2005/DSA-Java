package SubsequenceDp;
import java.util.Arrays;

public class LongestStringChain {
  // lc-1048. Longest String Chain
  class Solution {
    public boolean valid(String s1,String s2){
        int n1=s1.length(),n2=s2.length();
        if(s1.length()+1!=s2.length())return false;
        int i=0,j=0,count=1;
        while(i<n1 && j<n2){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;j++;
            }else{
                j++;
                count--;
                if(count<0)return false;
            }
        }
        return true;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int dp[]=new int[n];
        int maxLen=1;
        for(int i=0;i<n;i++)dp[i]=1;
        for(int i=1;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(valid(words[prev],words[i]) && dp[prev]+1>dp[i]){
                    dp[i]=1+dp[prev];  
                }
            }
            maxLen=Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
}
