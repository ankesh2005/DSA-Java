package BinarySearch;

import java.util.Arrays;

public class Heaters {
  // lc-475. Heaters
  class Solution {
    public int[] binarySearch(int key,int[] arr){
        int s=0,e=arr.length-1;
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        while(s<=e){
            int mid=(s+e)/2;
            if(key==arr[mid]){
                return new int[]{arr[mid],arr[mid]};
            }else if(arr[mid]<key){
                ans[0]=arr[mid];//just smaller
                s=mid+1;
            }else{
                ans[1]=arr[mid];//just bigger
                e=mid-1;
            }
        }
        return ans;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius=0;
        for(int i=0;i<houses.length;i++){
            int[] temp=binarySearch(houses[i],heaters);
            int js=temp[0]==-1?Integer.MAX_VALUE:houses[i]-temp[0];//just smaller distance
            int jb=temp[1]==-1?Integer.MAX_VALUE:temp[1]-houses[i];//just bigger distance
            radius=Math.max(radius,Math.min(js,jb));
        }
        return radius;
    }
}
}
