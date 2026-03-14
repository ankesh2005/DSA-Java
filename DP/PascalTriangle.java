import java.util.ArrayList;
import java.util.List;

public class PascalTriangle{
  // lc-118. Pascal Triangle 1
  class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)temp.add(1);
                else{
                    temp.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
                }
            }
            pascal.add(temp);
        }
        return pascal;
    }
  }
  // lc-119. Pascal Triangle 2
  class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)temp.add(1);
                else{
                    temp.add(ans.get(j-1)+ans.get(j));
                }
            }
            ans=temp;
        }
        return ans;
    }
}
}