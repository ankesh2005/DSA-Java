import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubarrayI {
 class Solution {
    public int longestBalanced(int[] nums) {
        Map<Integer,Integer> e=new HashMap<>();
        Map<Integer,Integer> o=new HashMap<>();
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(max>=n-i) break;
            for(int j=i;j<n;j++){
                int x=nums[j];
                if(x%2==0){
                    e.put(x,e.getOrDefault(x,0)+1);
                }else{
                    o.put(x,o.getOrDefault(x,0)+1);
                }
                if(e.size()==o.size()){
                    max=Math.max(max,j-i+1);
                }
            }
            e.clear();
            o.clear();
        }
        return max;
    }
} 
}
