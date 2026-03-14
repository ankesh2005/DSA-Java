import java.util.Stack;

public class LongestValidParenthesis {
  //lc-32. Longest Valid Parenthesis
  class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                ans=Math.max(ans,i-st.peek());
            }
        }
        return ans;
    }
}
}
