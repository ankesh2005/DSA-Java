package Stack;

public class CreateMaximumNumber {
  //lc-321. Create Maximum Number
  class Solution {
    int[] semimonotonic(int nums[], int k) {
        int[] stack = new int[k];
        int top = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && stack[top] < nums[i] && top + 1 + n - i > k) {
                top--;
            }
            if (top + 1 < k) {
                stack[++top] = nums[i];
            }
        }
        return stack;
    }
    boolean checkToTake(int[] nums1,int[] nums2,int i,int j){
        while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
            i++;j++;
        }
        if(j == nums2.length) return true;
        if(i == nums1.length) return false;
        return nums1[i]>nums2[j];
    }
    int[] merge(int[] nums1,int[] nums2){
        int i=0,j=0;
        int n=nums2.length;
        int m=nums1.length;
        int res[]=new int[nums1.length+nums2.length];
        int k=0;
        while(i<m && j<n){
            if(checkToTake(nums1,nums2,i,j)){
                res[k++]=nums1[i++];
            }else{
                res[k++]=nums2[j++];
            }
        }
        while(i<m){
            res[k++]=nums1[i++];
        }
        while(j<n){
            res[k++]=nums2[j++];
        }
        return res; 
    }
    boolean max(int nums1[],int[] nums2){
        int i=0;
        int n=nums1.length;
        while(i<n){
            if(nums2[i]>nums1[i])return false;
            if(nums1[i]>nums2[i])return true;
            i++;
        }
        return true;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res=new int[k];
        for(int i=0;i<=m;i++){
            int j=k-i;
            if(j<0 || j>n)continue;
            int[] mono1=semimonotonic(nums1,i);
            int[] mono2=semimonotonic(nums2,j);
            int[]temp=merge(mono1,mono2);
            if(!max(res,temp)){
                res=temp;
            }
        }
        return res;
    }
}
}
