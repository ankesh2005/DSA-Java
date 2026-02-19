public class CountBinarySubstrings {
  class Solution {
    //  static {
    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    //         try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
    //             fw.write("000");
    //         } catch (java.io.IOException e) {
    //         }
    //     }));
    // }
    // lc-693
    public int countBinarySubstrings(String str) {
        int s=0,e=0,ans=0;
        int zc=0,oc=0;
        int n=str.length();
        int cy=str.charAt(0)-'0';
        while(e<n){
            char ch=str.charAt(e);
            if(ch=='0'){
                if(cy==1)zc=0;
               if(oc!=0) ans++;
               zc++;
               cy=0;
               if(oc>0)oc--;
            }else{
                if(cy==0)oc=0;
                if(zc!=0) ans++;
                oc++;
                if(zc>0)zc--;
                cy=1;
            }
            e++;
        }
        return ans;
    }
}
}
