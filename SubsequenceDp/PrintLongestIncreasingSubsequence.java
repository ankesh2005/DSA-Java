package SubsequenceDp;
import java.util.ArrayList;
import java.util.Collections;

public class PrintLongestIncreasingSubsequence {

  class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int[] dp=new int[n];
        int hash[]=new int[n];
        for(int idx=0;idx<n;idx++){
            hash[idx]=idx;
            dp[idx]=1;
        }
        int mini=1,lastidx=0;
        for(int idx=1;idx<n;idx++){
            for(int prev=0;prev<idx;prev++){
                if(arr[prev]<arr[idx] && (1+dp[prev])>dp[idx]){
                    dp[idx]=1+dp[prev];
                    hash[idx]=prev;
                }
            }
            if(dp[idx]>mini){
                mini=dp[idx];
                lastidx=idx;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(hash[lastidx]!=lastidx){
            ans.add(arr[lastidx]);
            lastidx=hash[lastidx];
        }
        ans.add(arr[lastidx]);
        Collections.reverse(ans);
        return ans;
        
    }
}

}