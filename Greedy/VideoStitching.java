package Greedy;

import java.util.Arrays;

public class VideoStitching {
  // lc-1024 Video Stitching
  class Solution {
    public int solve(int[][] clips,int idx,int start,int end,int[][] dp){
        int n=clips.length;
        if(start>=end)return 0;
        if(idx==n)return Integer.MAX_VALUE;
        if(dp[idx][start]!=-1)return dp[idx][start];
        int ans=Integer.MAX_VALUE;
        for(int i=idx;i<n;i++){
            if(clips[i][0]<=start){
                int count=solve(clips,idx+1,clips[i][1],end,dp);
                if(count!=Integer.MAX_VALUE){
                    ans=Math.min(1+count,ans);
                }
            }
        }
        return dp[idx][start]=ans;
    }
    public int memo(int[][] clips,int time){
        int n=clips.length;
        int[][] dp=new int[n][time];
        for(int[] row:dp)Arrays.fill(row,-1);
        Arrays.sort(clips,(a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int ans=solve(clips,0,0,time,dp);
         return ans==Integer.MAX_VALUE?-1:ans;
       
    }
    public int videoStitching(int[][] clips, int time) {
        // return memo(clips,time);
        //greedy
        Arrays.sort(clips,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int start=0;
        int currend=0,ans=0,i=0,n=clips.length;
        while(currend<time){
            int nextend=currend;
            while(i<n && clips[i][0]<=currend){
                nextend=Math.max(nextend,clips[i][1]);
                i++;
            }
            if(nextend==currend)return -1;
            currend=nextend;
            ans++;
        }
        return ans;
    }
}
}
