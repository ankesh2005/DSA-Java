public class MinimumDeletionstoMakeStringBalanced {
  class Solution {
    public int minimumDeletions(String s) {
        // Stack<Character> st=new Stack<>();
        // int count=0;
        // for(int i=0;i<s.length();i++){
        //     char temp=s.charAt(i);
        //     if(st.size()>0 && (st.peek()=='b'&&temp=='a')){
        //         st.pop();
        //         count++;
        //     }else{
        //         st.push(temp);
        //     }
        // }
        // return count;

        int n=s.length();
        // acount is right count of a & bCount is left count of b at any index
        // int aCount=0,bCount=0;
        // for(int i=n-1;i>=0;i--){
        //     if(s.charAt(i)=='a'){
        //         aCount++;
        //     }
        // }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     int x=s.charAt(i);
        //     if(x=='a'){
        //         aCount--;
        //         min=Math.min(min,aCount+bCount);
        //     }
        //     else{
        //         min=Math.min(min,aCount+bCount);
        //         bCount++;
        //     }
        // }
        // return min;


        // int dp[]=new int[n+1];
        int dp[]=new int[2];
        int bcount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                // dp[i+1]=dp[i];
                dp[1]=dp[0];
                bcount++;
            }else{
                // dp[i+1]=Math.min(dp[i]+1,bcount);
                dp[1]=Math.min(dp[0]+1,bcount);
            }
            dp[0]=dp[1];
        }
        // return dp[n];
        return dp[0];
    }
}
}
