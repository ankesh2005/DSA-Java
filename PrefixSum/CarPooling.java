package PrefixSum;

public class CarPooling {
  // lc-1094. Car Pooling
  public boolean carPooling(int[][] trips, int capacity) {
        int pre[]=new int[1001];
        for(int[] trip:trips){
            int from=trip[1];
            int to=trip[2];
            int cap=trip[0];
            pre[from]+=cap;
            pre[to]-=cap;
        }
        int max=0;
        for(int i=0;i<1001;i++){
            if(i-1>0)pre[i]=pre[i-1]+pre[i];
            max=Math.max(pre[i],max);
        }
        return max<=capacity;
    }
}
