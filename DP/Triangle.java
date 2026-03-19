import java.util.ArrayList;
import java.util.List;

public class Triangle {
  // lc-120. Triangle
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> ans=new ArrayList<>();
        ans.add(triangle.get(0).get(0));
        for(int i=1;i<triangle.size();i++){
            List<Integer>temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 ){
                    temp.add(ans.get(0)+triangle.get(i).get(j));
                }else if(j==i){
                     temp.add(ans.get(j-1)+triangle.get(i).get(j));
                }else{
                    temp.add(Math.min(ans.get(j-1),ans.get(j))+triangle.get(i).get(j));
                }
            }
            ans=temp;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ans.size();i++){
            min=Math.min(min,ans.get(i));
        }
        return min;
    }
}
}