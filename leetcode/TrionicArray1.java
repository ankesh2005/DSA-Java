public class TrionicArray1 {
    private int increasing(int[] nums,int k){
        while(k<nums.length-1 && nums[k+1]>nums[k] ){
            k++;
        }
        return k;
    }
    private int decreasing(int[] nums,int k){
        while(k<nums.length-1 && nums[k+1]<nums[k]){
            k++;
        }
        return k;
    }
    public boolean isTrionic(int[] nums) {
        int n=nums.length-1;
        int p=increasing(nums,0);
        if(p==n ||p==0) return false;
        int q=decreasing(nums,p);
        if(q==n || q==0) return false;
        int e=increasing(nums,q);
        if(e==n) return true;
        return false;
    }
}
