package Stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
  // lc-84. Largest Rectangle in Histogram
  class Solution {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        st.push(-1);
        for(int i=0;i<arr.length;i++){
            while(st.peek()!=-1 && arr[st.peek()]>=arr[i]){
                int top=st.pop();
                int area=arr[top]*(i-st.peek()-1);
                max=Math.max(area,max);
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int top=st.pop();
            int area=arr[top]*(arr.length-st.peek()-1);
            max=Math.max(area,max);
        }
        return max;
    }
}

}
