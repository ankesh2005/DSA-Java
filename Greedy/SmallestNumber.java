package Greedy;

public class SmallestNumber {
  public String smallestNumber(int s, int d) {
        if(s>d*9) return "-1";
        int[] digit=new int[d];
        digit[0]=1;
        s--;
        for(int i=d-1;i>=0;i--){
            if(s>=9){
                digit[i]=9;
                s-=9;
            }else{
                digit[i]+=s;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<d;i++)sb.append(digit[i]);
        return sb.toString();
    }
}
