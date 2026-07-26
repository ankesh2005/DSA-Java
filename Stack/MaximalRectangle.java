package Stack;

import java.util.Stack;

public class MaximalRectangle {
  // lc-85. Maximal Rectangle
  class Solution {
    int area(int[] arr){
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        int max=-1;
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && arr[st.peek()]>=arr[i]){
                int top=st.pop();
                int width=i-st.peek()-1;
                int height=arr[top];
                max=Math.max(max,height*width);
            }
            st.push(i);
        }
        while(st.peek()!=-1){
            int top=st.pop();
            int width=n-st.peek()-1;
            int height=arr[top];
            max=Math.max(max,height*width);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int cols=matrix[0].length;
        int pre[]=new int[cols];
        for(int i=0;i<cols;i++){
            if(matrix[0][i]=='1'){
                pre[i]=1;
            }
        }
        int max=area(pre);
        for(int i=1;i<matrix.length;i++){
            int cur[]=new int[cols];
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    cur[j]=1+pre[j];
                }
            }
            pre=cur;
            max=Math.max(max,area(pre));
        }
        return max;
    }
}
}
