package Heaps;
public class Ipo {
  // lc-502. IPO
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=capital[i];
            pair[i][1]=profits[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        int ans=0;
        int cnt=0;
        while(j<n){
            while(j<n && pair[j][0]<=w){
                maxHeap.add(pair[j][1]);
                j++;
            }
            if(maxHeap.isEmpty()){
                return w;
            }
            if(cnt==k)return w;
            cnt++;
            w+=maxHeap.poll();
        }
        while(!maxHeap.isEmpty() && cnt<k){
            w+=maxHeap.poll();
            cnt++;
        }
        return w;
    }
}