package SlindingWindow;
import java.util.HashMap;
import java.util.Map;

public class FruiIntoBaskets{
  // lc-904. Fruit Into Baskets
  class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=0,l=0;
        int n=fruits.length;
        int ans=0;
        while(r<n){
            int fruit=fruits[r];
            map.put(fruit,map.getOrDefault(fruit,0)+1);
            while(l<n && map.size()>2){
                int lfruit=fruits[l];
                if(map.get(lfruit)==1)map.remove(lfruit);
                else{
                    map.put(lfruit,map.get(lfruit)-1);
                }
                l++;
            }
            r++;
            ans=Math.max(ans,r-l);
        }
        return ans;
    }
}
}