import java.util.Arrays;
//3634. Minimum Removals to Balance Array
public class RemovalstoBalanceArray {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=0;
        int n=nums.length;
        int ans=n;
        while(i<n){
            while(j<n && (long)k*nums[i]<=nums[j]){
                j++;
            }
            ans=Math.min(ans,n-j+i);
            i++;
        }
        return ans;
}
}

