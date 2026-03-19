public class MaximumSwap {
  // lc-670 Maximum Swap
  class Solution {
    public int maximumSwap(int num) {
        if(num==0)return 0;
        int len=(int)Math.log10(num)+1;
        int rl[]=new int[len];//rightlargest
        String s=String.valueOf(num);
        rl[len-1]=len-1;
        for(int i=len-2;i>=0;i--){
            int curr=s.charAt(i)-'0';
            int next=s.charAt(rl[i+1])-'0';
            if(curr<=next){
                rl[i]=rl[i+1];
            }
            else{
                rl[i]=i;
            }
        }
        char[] arr=s.toCharArray();
        for(int i=0;i<len;i++){
            if(arr[i] != arr[rl[i]] ){
                char ch=arr[i];
                arr[i]=arr[rl[i]];
                arr[rl[i]]=ch;
                break;
            }
        }
        int ans=0;
        for(int i=0;i<len;i++){
            ans=ans*10+(arr[i]-'0');
        }
        return ans;

    }
}
}
