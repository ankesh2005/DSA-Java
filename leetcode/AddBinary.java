public class AddBinary {
  class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb1=new StringBuilder(a).reverse();
        StringBuilder sb2=new StringBuilder(b).reverse();
        StringBuilder res=new StringBuilder();
        int max=a.length()>b.length()?a.length():b.length();
        int carry=0;
        for(int i=0;i<max;i++){
            int ca=i<a.length()?sb1.charAt(i)-'0':0;
            int cb=i<b.length()?sb2.charAt(i)-'0':0;
            int total=ca+cb+carry;
            int bin=total%2;
            carry=total/2;
            res.append(bin);
        }
        if(carry==1){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
}
