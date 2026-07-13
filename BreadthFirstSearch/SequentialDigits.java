package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class SequentialDigits {
  // lc-1291. Sequential Digits
  class Solution {
    void bfs(Queue<Integer>temp,List<Integer>ans,int low,int high){
        while(!temp.isEmpty()){
            int num=temp.poll();
            if(num>=low && num<=high) ans.add(num);
            int last=num%10;
            if(last>=9)continue;
            last= last+1;
            num=num*10+last;
            temp.add(num);
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        int llen=(int)Math.floor(Math.log(low))+1;
        int hlen=(int)Math.floor(Math.log(high))+1;
        Queue<Integer> temp=new ArrayDeque<>();
        for(int i=1;i<=8;i++){
            temp.add(i);
        }
        bfs(temp,ans,low,high);
        Collections.sort(ans);
        return ans;
    }
}
}
