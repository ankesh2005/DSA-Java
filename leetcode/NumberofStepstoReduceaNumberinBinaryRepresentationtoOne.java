public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
  class Solution {
    // 1404. Number of Steps to Reduce a Number in Binary Representation to One

    private boolean isOne(String s){
        int n=s.length()-1;
        if(s.charAt(n)!='1')return false;
        n=n-1;
        while(n>=0){
            if(s.charAt(n)!='0')return false;
            n--;
        }
        return true;
    }
    private String addOne(String s){
        StringBuilder str=new StringBuilder(s).reverse();
        StringBuilder sb=new StringBuilder();
        int carry=1;
        int l=s.length();
        int i=0;
        while(i<l){
            if(str.charAt(i)=='0'){
                sb.append(carry);
                carry=0;
            }else{
                sb.append((carry+1)%2);
                carry=(carry+1)/2;
            }
            i++;
        }
        if(carry==1) sb.append(carry);
        return sb.reverse().toString();
    }

    public int numSteps(String s) {
        int ans=0;
        
        while(!isOne(s)){
            int n=s.length()-1;
            if(s.charAt(n)=='1'){
                s=addOne(s);
            }else{
                s=s.substring(0,n);
            }
            ans++;
        }
        return ans;
    }
}
}
