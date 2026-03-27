package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
  // lc-969 Pancake Sorting
   public int find(int[] arr,int n){
        for(int i=0;i<n;i++){
            if(arr[i]==n)return i+1;
        }
        return -1;
    }
    public void flip(int[] arr,int k){
        for(int i=0;i<k/2;i++){
            int temp=arr[i];
            arr[i]=arr[k-1-i];
            arr[k-1-i]=temp;
        }
    }
    public boolean check(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1)return false;
        }
        return true;
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer>ans=new ArrayList<>();
        int n=arr.length;
        while(!check(arr)){
            int k=find(arr,n);
            flip(arr,k);
            ans.add(k);
            flip(arr,n);
            ans.add(n);
            n--;
        }
        return ans;   
    }
}
