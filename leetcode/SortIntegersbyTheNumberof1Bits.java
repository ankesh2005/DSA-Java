import java.util.Arrays;

public class SortIntegersbyTheNumberof1Bits {
  // lc-1356
 class Solution {
    public int[] sortByBits(int[] arr) {
        // int n= 15;
        // int ans=0;
        // while(n>0){
        //     ans+=n&1;
        //     n=n>>1;
        // }
        // System.out.println(ans);
        
       // Map<Integer,Integer> map=new HashMap<>();
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // for(int num:arr){
        //     int count=Integer.bitCount(num);
        //     map.put(num,count);
        // } 
        Arrays.sort(boxed,(a,b)->{
            int dif=Integer.bitCount(a)-Integer.bitCount(b);
            if(dif==0)return a-b;
            else return dif;
        });
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();

    }
} 
}
