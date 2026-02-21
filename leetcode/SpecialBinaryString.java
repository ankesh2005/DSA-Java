import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {
    // lc-761
  class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specials=new ArrayList<>();
        int sum=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            sum=sum+(s.charAt(i)=='1'?1:-1);
            if(sum==0){
               String str="1"+ makeLargestSpecial(s.substring(start+1,i))+"0";
               specials.add(str);
               start=i+1;
            }
        }
        Collections.sort(specials);
        Collections.reverse(specials);
        return String.join("",specials);
    }
}
}
