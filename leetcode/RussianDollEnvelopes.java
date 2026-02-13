import java.util.ArrayList;
import java.util.Arrays;

// 354. Russian Doll Envelopes
public class RussianDollEnvelopes {
  class Solution {
    private void replace(ArrayList<Integer> ans,int ele){
        int lb=-1;
        int f=0;
        int h=ans.size()-1;
        while(f<=h){
            int mid=(f+h)/2;
            if(ans.get(mid)>=ele){
                lb=mid;
                h=mid-1;
            }else{
                f=mid+1;
            }
        }
        ans.set(lb,ele);
    }
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)->(a[0]!=b[0])?Integer.compare(a[0],b[0]):Integer.compare(b[1],a[1]));
        // lis lga diya
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] e:arr){
            int ele=e[1];
            if(ans.size()==0 || ans.get(ans.size()-1)<ele) ans.add(ele);
            else{
                replace(ans,ele);
            }
        }
        return ans.size();
    }

}
}
