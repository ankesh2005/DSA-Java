public class BinaryWatch {

  // lc-401
  class Solution {
    private void helper(int on,List<String> ans){
        int tb=4+6;//4 hr bits 6 min bits
        for(int i=0;i<(1<<tb);i++){
            if(Integer.bitCount(i)==on){
                int hr=i>>6;
                int min= i& ((1<<6)-1);
                if(hr<=11 && min<=59){
                    String m="";
                    if(min<10){
                        m="0"+String.valueOf(min);
                    }else{
                        m=String.valueOf(min);
                    }
                    String h=String.valueOf(hr);
                    ans.add(h+":"+m);
                }
            }
        }
        
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans=new ArrayList<>();
        // helper(turnedOn,ans);
        for(int hr=0;hr<=11;hr++){
            for(int min=0;min<=59;min++){
                if(Integer.bitCount(hr)+Integer.bitCount(min)==turnedOn){
                    String m="";
                    if(min<10){
                        m="0"+String.valueOf(min);
                    }else{
                        m=String.valueOf(min);
                    }
                    String h=String.valueOf(hr);
                    ans.add(h+":"+m);
                }
            }
        }
        return ans;
    }
}
}
